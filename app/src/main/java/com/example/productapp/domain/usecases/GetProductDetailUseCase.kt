package com.example.productapp.domain.usecases

import com.example.productapp.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Int) = repository.getProductDetail(id)
}
