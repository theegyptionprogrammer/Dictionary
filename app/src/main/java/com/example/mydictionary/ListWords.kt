package com.example.mydictionary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.LinearLayout

class ListWords : AppCompatActivity() {

    lateinit var button: Button

    companion object {
        lateinit var helper: MyDBHandler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_words)
        button = findViewById(R.id.Refresh)
        helper = MyDBHandler(this)
        viewCustomers()
        button.setOnClickListener { viewCustomers() }
    }

    private fun viewCustomers() {
        val wordsList = helper.getallwords()
        val rv: RecyclerView = findViewById(R.id.my_recycler_view)
        val adapter = RVAdapter(wordsList)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv.adapter = adapter
    }

    override fun onResume() {
        viewCustomers()
        super.onResume()
    }
}