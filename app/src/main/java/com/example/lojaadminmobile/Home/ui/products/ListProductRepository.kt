package com.example.lojaadminmobile.Home.ui.products

sealed class ListProductRepository {
    data class Product(val data:ProductsRepository ): ListProductRepository()
}