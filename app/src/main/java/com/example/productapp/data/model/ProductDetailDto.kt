package com.example.productapp.data.model

data class ProductDetailDto(
    val id: Int,
    val title: String,
    val summary: String,
    val description: String,
    val price: String,
    val imageUrl: String
)