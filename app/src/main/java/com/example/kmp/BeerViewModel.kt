package com.example.kmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmp.ui.theme.Beer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BeerViewModel(private val repository: BeerRepository) : ViewModel() {
    private val _beers = MutableStateFlow<List<Beer>>(emptyList());
    private val mutableStateFlow = _beers
    val beers: StateFlow<List<Beer>> get() = _beers
    init {
        fetchBeers()
    }
    private fun fetchBeers() {
        viewModelScope.launch {
            try {
                _beers.value = repository.fetchBeers()
            } catch (e: Exception) {
                println(e);
            }
        }


    }


}