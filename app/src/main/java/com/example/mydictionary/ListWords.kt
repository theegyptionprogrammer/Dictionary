package com.example.mydictionary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import kotlinx.android.synthetic.main.list_words.*


class ListWords : AppCompatActivity() {

    lateinit var button1: Button

    companion object {
        lateinit var helper: MyDBHandler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_words)
        button1 = findViewById(R.id.Refresh)
        helper = MyDBHandler(this)
        setUpRecyclerView()
        button1.setOnClickListener { setUpRecyclerView() }
    }

    private fun setUpRecyclerView() {
        val listwords = helper.getallwords(this)
        val adapter = RVAdapter(this, listwords)
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.adapter = adapter
    }

    override fun onResume() {
        setUpRecyclerView()
        super.onResume()
    }


}