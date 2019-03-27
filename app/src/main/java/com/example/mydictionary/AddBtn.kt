package com.example.mydictionary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.add_btn.*
import java.util.*

class AddBtn : AppCompatActivity() {

    companion object {
        lateinit var helper: MyDBHandler
    }

    private val Request_Code_Speech_Input = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_btn)
        Insert.setOnClickListener { insert() }
        ENSpeaker.setOnClickListener { startSpeechToText1() }


    }

    fun insert() {

        helper = MyDBHandler(this)

        if (ETEnglish.text.isEmpty() && ETRussian.text.isEmpty()) {
            Toast.makeText(this, "write something", Toast.LENGTH_SHORT).show()
        } else {
            try {
                val word = Word(String(), String())
                word.EnWord = ETEnglish.text.toString()
                word.RuWord = ETRussian.text.toString()
                helper.insertword(this, word)
                clearET()
                ETEnglish.requestFocus()
                ETRussian.requestFocus()
                Toast.makeText(this, "Inserted", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun clearET() {
        ETEnglish.text.clear()
        ETRussian.text.clear()
    }

    fun startSpeechToText1() {
        val SpeechRecognizerintent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        SpeechRecognizerintent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        SpeechRecognizerintent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        SpeechRecognizerintent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi say something")
        try {
            startActivityForResult(SpeechRecognizerintent, Request_Code_Speech_Input)
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            Request_Code_Speech_Input -> {
                if (resultCode == Activity.RESULT_OK && null != data) {
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    ETEnglish.setText(result[0])
                }
            }
        }
    }
}