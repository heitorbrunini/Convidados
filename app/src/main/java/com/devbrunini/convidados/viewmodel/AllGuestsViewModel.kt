package com.devbrunini.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devbrunini.convidados.model.GuestsModel
import com.devbrunini.convidados.repositories.GuestsRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: GuestsRepository  = GuestsRepository.getInstance(application.applicationContext)
    fun getAll() {
        listAllGuests.value = repository.getAll()
    }

    private val listAllGuests = MutableLiveData<List<GuestsModel>>()
    val guests: LiveData<List<GuestsModel>> = listAllGuests
}