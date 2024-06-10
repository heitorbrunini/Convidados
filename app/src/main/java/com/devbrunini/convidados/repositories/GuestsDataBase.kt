package com.devbrunini.convidados.repositories

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.devbrunini.convidados.constants.DBConstants

class GuestsDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object{

        private const val NAME = "guestdb"
        private const val VERSION = 1

    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${DBConstants.GUESTS.TABLE_NAME} " +
                "(${DBConstants.COLUMNS.ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${DBConstants.COLUMNS.NAME} TEXT, " +
                "${DBConstants.COLUMNS.PRESENCE} INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}