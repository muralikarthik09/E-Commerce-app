package com.example.productapp.domain.model

data class ProductDetail(
    val id: Int,
    val title: String,
    val summary: String,
    val description: String,
    val price: String,
    val imageUrl: String
)