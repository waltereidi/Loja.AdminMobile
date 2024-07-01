package com.example.lojaadminmobile.Home.ui.requests.requestDetails

sealed class ListRequestProductsRepository {
    data class Request(val data:RequestsProductsRepository ): ListRequestProductsRepository()

}