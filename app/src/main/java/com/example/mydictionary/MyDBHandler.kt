package com.example.mydictionary

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val SQL_CREATE_ENTRIES = ("create table $TableWord ("
                + "$ColumnEnWord "
                + "$ColumnRuWord )")
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val SQL_UPGRADE_ENTRIES = ("drop the table if exists" + TableWord)
        db?.execSQL(SQL_UPGRADE_ENTRIES)
        onCreate(db)
    }

    val dbhelper: MyDBHandler? = null
    val word = Word(String(), String())
    val myword = ArrayList<Word>()

    fun insertword(word: Word) {
        val db = dbhelper?.readableDatabase
        val values = ContentValues()

        values.put(MyDBHandler.ColumnEnWord, word.EnWord)
        values.put(MyDBHandler.ColumnRuWord, word.RuWord)
        db?.insert(TableWord, null, values)
        db?.close()
    }

    fun searchword() {

    }

    fun getallwords(): ArrayList<Word> {
        val selectquery = "select * From $TableWord"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectquery, null)
        var context: Context? = null
        var list: ArrayList<Word> = ArrayList()

        while (cursor.moveToNext()) {
            word.EnWord = cursor.getString(cursor.getColumnIndex(ColumnEnWord))
            word.RuWord = cursor.getString(cursor.getColumnIndex(ColumnRuWord))
            list.add(word)
        }

        cursor.close()
        db.close()
        return list

    }

    fun deleteword() {

    }

    companion object {
        const val DATABASE_NAME = "My Data base"
        var TableWord = "word"
        const val DATABASE_VERSION = 1
        var ColumnEnWord = "EnWord"
        var ColumnRuWord = "RuWord"
    }
}