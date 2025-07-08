package com.example.productapp.domain.usecases

import com.example.productapp.domain.repository.ProductRepository

class GetProductsUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke() = repository.getProducts()
}