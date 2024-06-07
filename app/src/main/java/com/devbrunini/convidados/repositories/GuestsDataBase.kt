package com.devbrunini.convidados.repositories

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class GuestsDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object{

        private const val NAME = "guestdb"
        private const val VERSION = 1

    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE Guests (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, presence INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}