package com.example.productapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.productapp.presentation.product_details.ProductDetailScreen
import com.example.productapp.presentation.product_list.ProductListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
            ProductListScreen(
                onItemClick = { selectedId ->
                    navController.navigate("detail/$selectedId")
                },
                navController
            )
        }

        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: return@composable
            ProductDetailScreen(productId = id, navController = navController)
        }
    }
}
