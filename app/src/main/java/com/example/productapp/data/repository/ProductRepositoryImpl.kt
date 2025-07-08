package com.example.productapp.data.repository

import com.example.productapp.data.mapper.toDomain
import com.example.productapp.data.remote.ProductApi
import com.example.productapp.domain.model.Product
import com.example.productapp.domain.model.ProductDetail
import com.example.productapp.domain.repository.ProductRepository

class ProductRepositoryImpl(private val api: ProductApi) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        val response = api.getProducts()
        return response.map { it.toDomain() }
    }

    override suspend fun getProductDetail(id: Int): ProductDetail {
        val response = api.getProductDetail(id)
        return response.toDomain()
    }
}
