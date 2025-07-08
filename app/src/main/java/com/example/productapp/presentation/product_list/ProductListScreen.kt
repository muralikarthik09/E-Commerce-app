package com.example.productapp.presentation.product_list

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.productapp.presentation.common.ErrorState
import com.example.productapp.presentation.common.LoadingState
import com.example.productapp.data.remote.RetrofitInstance
import com.example.productapp.data.repository.ProductRepositoryImpl
import com.example.productapp.domain.usecases.GetProductsUseCase
import com.example.productapp.presentation.product_list.components.ProductListContent
import com.example.productapp.presentation.state.UIState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    onItemClick: (Int) -> Unit,
    navController: NavController
) {
    val viewModel = remember {
        ProductListViewModel(
            GetProductsUseCase(ProductRepositoryImpl(RetrofitInstance.api))
        )
    }

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Product List") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val state = uiState) {
                is UIState.Loading -> LoadingState()
                is UIState.Success -> ProductListContent(
                    products = state.data,
                    onItemClick = onItemClick
                )

                is UIState.Error -> ErrorState(state.message)
            }
        }
    }
}
