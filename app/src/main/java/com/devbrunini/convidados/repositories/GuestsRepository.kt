package com.devbrunini.convidados.repositories

import android.content.ContentValues
import android.content.Context
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

            db.insert("Guests", null, values)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun update(){

    }

}