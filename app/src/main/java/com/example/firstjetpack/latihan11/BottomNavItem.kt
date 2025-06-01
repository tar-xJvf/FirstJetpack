package com.example.firstjetpack.latihan11

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

// Contoh daftar item navigasi
object BottomNavigationItems {
    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home, "home_route"),
        BottomNavItem("Products", Icons.Default.ShoppingCart, "product_route"),
        BottomNavItem("Profile", Icons.Default.Person, "profile_route")
    )
}
