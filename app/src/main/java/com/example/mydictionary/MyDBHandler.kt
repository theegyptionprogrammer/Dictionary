package com.example.mydictionary

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

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

    val word = Word(String(), String())

    fun insertword(myctx: Context, word: Word) {
        val values = ContentValues()

        values.put(MyDBHandler.ColumnEnWord, word.EnWord)
        values.put(MyDBHandler.ColumnRuWord, word.RuWord)
        val db = this.writableDatabase
        try {
            db.insert(TableWord, null, values)
            Toast.makeText(myctx, "word have been inserted", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(myctx, e.message, Toast.LENGTH_SHORT).show()
        }

        db.close()
    }

    fun searchword() {

    }

    val mylist: MutableList<Word>
        get() {
        val selectquery = "select * From $TableWord"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectquery, null)
        var words = ArrayList<Word>()

        while (cursor.moveToNext()) {
            word.EnWord = cursor.getString(cursor.getColumnIndex(ColumnEnWord))
            word.RuWord = cursor.getString(cursor.getColumnIndex(ColumnRuWord))
            words.add(word)
        }

        cursor.close()
        db.close()
        return words

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