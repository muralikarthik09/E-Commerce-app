package com.example.productapp.data.remote

import com.example.productapp.data.model.ProductDetailDto
import com.example.productapp.data.model.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products.json")
    suspend fun getProducts(): List<ProductDto>

    @GET("product-details/{id}.json")
    suspend fun getProductDetail(@Path("id") id: Int): ProductDetailDto
}