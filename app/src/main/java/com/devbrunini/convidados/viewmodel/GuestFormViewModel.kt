package com.devbrunini.convidados.viewmodel

import androidx.lifecycle.ViewModel
import com.devbrunini.convidados.repositories.GuestsRepository

class GuestFormViewModel: ViewModel() {
    val repository = GuestsRepository.getInstance()

}