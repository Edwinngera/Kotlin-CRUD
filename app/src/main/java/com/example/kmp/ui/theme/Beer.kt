package com.example.kmp.ui.theme

data class Beer(
    val id: Int,
    val name: String,
    val price: String,
    val image: String,
    val rating: Rating

)


data class Rating(
    val average:Double,
    val reviews:Int
)



