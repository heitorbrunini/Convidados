package com.devbrunini.convidados.repositories

import android.content.ContentValues
import android.content.Context
import com.devbrunini.convidados.constants.DBConstants
import com.devbrunini.convidados.model.GuestsModel

class GuestsRepository private constructor(context: Context){

    private val guestsDataBase =  GuestsDataBase(context)

    //singleton
    companion object{

        private lateinit var repository : GuestsRepository
        fun getInstance(context: Context): GuestsRepository {
            if (!::repository.isInitialized) {
                repository = GuestsRepository(context)
            }
            return repository
        }
    }

    fun save(guest: GuestsModel) : Boolean {

        try {
            val db = guestsDataBase.writableDatabase
            val values = ContentValues()

            values.put("name", guest.name)
            values.put("presence", if (guest.presence) 1 else 0)

            db.insert(DBConstants.GUESTS.TABLE_NAME, null, values)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun update(guest: GuestsModel): Boolean {

        try {
            val db = guestsDataBase.writableDatabase
            val values = ContentValues()
            val args = arrayOf(guest.id.toString())
            values.put("name", guest.name)
            values.put("presence", if (guest.presence) 1 else 0)
            db.update(DBConstants.GUESTS.TABLE_NAME, values, "id = ?", args)
            return true
        }catch (e: Exception){
            return false
        }

    }

    fun delete(id: Int): Boolean {
        try {
            val db = guestsDataBase.writableDatabase
            val args = arrayOf(id.toString())
            db.delete(DBConstants.GUESTS.TABLE_NAME, "id = ?", args)
            return true
        }catch (e: Exception){
            return false
        }
    }

    fun getAll(): List<GuestsModel> {
        val db = guestsDataBase.readableDatabase
        val args = arrayOf(
            DBConstants.COLUMNS.ID,
            DBConstants.COLUMNS.NAME,
            DBConstants.COLUMNS.PRESENCE
        )

        val list = ArrayList<GuestsModel>()
        val cursor = db.rawQuery("SELECT * FROM " + DBConstants.GUESTS.TABLE_NAME, args)

        if (cursor.count > 0 && cursor!=null) {
            while (cursor.moveToNext()) {
                val id = cursor.getInt(cursor.getColumnIndex(DBConstants.COLUMNS.ID))
                val name = cursor.getString(cursor.getColumnIndex(DBConstants.COLUMNS.NAME))
                val presence = cursor.getInt(cursor.getColumnIndex(DBConstants.COLUMNS.PRESENCE))
                list.add(GuestsModel(id, name, presence == 1))
            }
            cursor.close()
        }
        return list

    }

}