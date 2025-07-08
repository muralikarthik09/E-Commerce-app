package com.example.productapp.presentation.product_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.domain.model.ProductDetail
import com.example.productapp.domain.usecases.GetProductDetailUseCase
import com.example.productapp.presentation.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val getProductDetailUseCase: GetProductDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState<ProductDetail>>(UIState.Loading)
    val uiState: StateFlow<UIState<ProductDetail>> = _uiState

    fun loadProductDetail(id: Int) {
        viewModelScope.launch {
            try {
                val product = getProductDetailUseCase(id)
                _uiState.value = UIState.Success(product)
            } catch (e: Exception) {
                _uiState.value = UIState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}
