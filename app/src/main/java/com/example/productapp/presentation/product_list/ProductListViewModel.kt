package com.example.productapp.presentation.product_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.domain.model.Product
import com.example.productapp.domain.usecases.ProductUseCases
import com.example.productapp.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val useCases: ProductUseCases
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState<List<Product>>>(UIState.Loading)
    val uiState: StateFlow<UIState<List<Product>>> = _uiState

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            try {
                val products = useCases.getProducts()
                _uiState.value = UIState.Success(products)
            } catch (e: Exception) {
                _uiState.value = UIState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}
