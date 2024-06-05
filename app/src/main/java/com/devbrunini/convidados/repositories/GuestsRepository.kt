package com.devbrunini.convidados.repositories

class GuestsRepository private constructor(){

    //singleton
    companion object{

        private lateinit var repository : GuestsRepository
        fun getInstance(): GuestsRepository {
            if (!::repository.isInitialized) {
                repository = GuestsRepository()
            }
            return repository
        }
    }


}