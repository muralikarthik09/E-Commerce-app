package com.example.productapp.domain.usecases

import com.example.productapp.domain.repository.ProductRepository

class GetProductDetailUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(id: Int) = repository.getProductDetail(id)
}