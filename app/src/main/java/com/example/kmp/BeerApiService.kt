package com.example.kmp
import com.example.kmp.ui.theme.Beer
import retrofit2.http.GET


interface BeerApiService {

    @GET("beers/ale")
    suspend fun getBeers(): List<Beer>


}