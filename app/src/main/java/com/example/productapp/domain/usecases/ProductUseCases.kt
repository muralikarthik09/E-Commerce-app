package com.example.productapp.domain.usecases

import javax.inject.Inject

data class ProductUseCases @Inject constructor(
    val getProducts: GetProductsUseCase,
    val getProductDetail: GetProductDetailUseCase
)