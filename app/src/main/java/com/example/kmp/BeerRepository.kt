package com.example.kmp

import com.example.kmp.ui.theme.Beer

class BeerRepository(private val apiService: BeerApiService) {
    suspend fun fetchBeers(): List<Beer> = apiService.getBeers()
}
