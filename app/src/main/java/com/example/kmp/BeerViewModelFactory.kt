package com.example.kmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BeerViewModelFactory(private val repository: BeerRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BeerViewModel::class.java)) {
            return BeerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

