package com.devbrunini.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.devbrunini.convidados.repositories.GuestsRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestsRepository.getInstance(application.applicationContext)

}