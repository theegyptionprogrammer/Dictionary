package com.example.mydictionary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.add_btn.*

class AddBtn : AppCompatActivity() {

    companion object {
        lateinit var helper: MyDBHandler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_btn)
        Insert.setOnClickListener { insert() }
    }

    fun insert() {

        helper = MyDBHandler(this)

        if (ETEnglish.text.isEmpty() && ETRussian.text.isEmpty()) {
            Toast.makeText(this, "write something", Toast.LENGTH_SHORT).show()
        } else {
            val word = Word(String(), String())
            word.EnWord = ETEnglish.text.toString()
            word.RuWord = ETRussian.text.toString()
            helper.insertword(this, word)
            clearET()
            ETEnglish.requestFocus()
            ETRussian.requestFocus()
            Toast.makeText(this, "Inserted", Toast.LENGTH_LONG).show()

        }
    }

    fun clearET() {
        ETEnglish.text.clear()
        ETRussian.text.clear()
    }
}