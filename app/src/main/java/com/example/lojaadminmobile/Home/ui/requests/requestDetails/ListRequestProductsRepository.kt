package com.example.lojaadminmobile.Home.ui.requests.requestDetails

sealed class ListRequestProductsRepository {
    data class RequestProduct(val data:RequestsProductsRepository ): ListRequestProductsRepository()

}