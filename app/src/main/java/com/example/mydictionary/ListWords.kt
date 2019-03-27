package com.example.mydictionary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.list_words.*


class ListWords : AppCompatActivity() {

    lateinit var button1: Button
    lateinit var ETE: EditText
    companion object {
        lateinit var helper: MyDBHandler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_words)
        button1 = findViewById(R.id.Refresh)
        ETE = findViewById(R.id.ETEnglish)
        val EnglishText = ETE.text.toString()
        helper = MyDBHandler(this)
        setUpRecyclerView()
        button1.setOnClickListener { setUpRecyclerView() }
    }

    private fun setUpRecyclerView(items: MutableList<Word>) {

        val adapter = RVAdapter(this, helper.mylist)
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.adapter = adapter
        adapter.additems(items)
    }

    private fun ListWords(): MutableList<Int> {
        val items = mutableListOf<Int>()
        for (i:) items.add(i)
        return items

    }

    override fun onResume() {
        setUpRecyclerView()
        super.onResume()
    }


}