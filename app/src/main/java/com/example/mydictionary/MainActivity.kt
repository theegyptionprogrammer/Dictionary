package com.example.mydictionary

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstintent = Intent(this, AddBtn::class.java)
        val secondintent = Intent(this, SearchBtn::class.java)
        val thirdintent = Intent(this, ListWords::class.java)
        AddWord.setOnClickListener {
            startActivity(firstintent)
        }
        SearchWord.setOnClickListener {
            startActivity(secondintent)
        }
        MyDataBase.setOnClickListener {
            startActivity(thirdintent)
        }

    }
}
