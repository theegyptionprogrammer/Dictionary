package com.example.mydictionary

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.word.view.*

class RVAdapter(mctx: Context, var ListWords: MutableList<Word>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    val mctx = mctx

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.word, parent, false))


    override fun getItemCount(): Int = ListWords.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myword: Word = ListWords[position]
        holder.TVEnglish.text = myword.EnWord
        holder.TVRussian.text = myword.RuWord
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        @SuppressLint("SetTextI18n")
        val UpdateButton = itemview.Update
        val DeleteButton = itemview.Update
        val TVEnglish = itemview.TVEnglish
        val TVRussian = itemview.TVRussian

    }
}