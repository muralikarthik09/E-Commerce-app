package com.example.productapp.domain.repository

import com.example.productapp.domain.model.Product
import com.example.productapp.domain.model.ProductDetail

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProductDetail(id: Int): ProductDetail
}