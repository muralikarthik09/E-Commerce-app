package com.example.productapp.data.repository

import android.util.Log
import com.example.productapp.data.mapper.toDomain
import com.example.productapp.data.remote.ProductApi
import com.example.productapp.domain.model.Product
import com.example.productapp.domain.model.ProductDetail
import com.example.productapp.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        val response = api.getProducts()
        Log.d("ProductRepository", "getProducts response: $response")
        return response.map { it.toDomain() }
    }

    override suspend fun getProductDetail(id: Int): ProductDetail {
        val response = api.getProductDetail(id)
        Log.d("ProductRepository", "getProductDetail($id) response: $response")
        return response.toDomain()
    }
}
