package com.example.productapp.domain.usecases

import com.example.productapp.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideProductUseCases(
        repository: ProductRepository
    ): ProductUseCases {
        return ProductUseCases(
            getProducts = GetProductsUseCase(repository),
            getProductDetail = GetProductDetailUseCase(repository)
        )
    }
}
