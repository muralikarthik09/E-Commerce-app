package com.example.productapp.presentation.product_list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.productapp.domain.model.Product

@Composable
fun ProductListContent(
    products: List<Product>,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(products) { product ->
            ProductListItem(product = product, onClick = onItemClick)
        }
    }
}
