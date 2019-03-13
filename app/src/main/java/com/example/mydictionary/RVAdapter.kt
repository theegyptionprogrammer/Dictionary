package com.example.mydictionary

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.word.view.*

class RVAdapter(private var ListWords: ArrayList<Word>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.word, parent, false))


    override fun getItemCount(): Int = ListWords.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word: Word = ListWords[position]
        holder.theTvEnglish.text = word.EnWord
        holder.theTvRussian.text = word.RuWord
    }


    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val theTvEnglish = itemview.TVEnglish
        val theTvRussian = itemview.TVRussian
        val theUpdate = itemview.Update
        val theDelete = itemview.Delete

    }
}