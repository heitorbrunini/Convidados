package com.devbrunini.convidados.repositories

import android.content.Context

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

    fun save() {


    }

    fun update(){

    }

}