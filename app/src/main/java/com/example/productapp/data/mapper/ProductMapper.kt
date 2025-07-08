package com.example.productapp.data.mapper

import com.example.productapp.data.model.ProductDto
import com.example.productapp.data.model.ProductDetailDto
import com.example.productapp.domain.model.Product
import com.example.productapp.domain.model.ProductDetail


fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        summary = summary,
        imageUrl = imageUrl
    )
}

fun ProductDetailDto.toDomain(): ProductDetail {
    return ProductDetail(
        id = id,
        title = title,
        summary = summary,
        description = description,
        price = price,
        imageUrl = imageUrl
    )
}
