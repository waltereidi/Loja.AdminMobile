package com.example.lojaadminmobile.Home.ui.requests

sealed class ListRequestRepository {
    data class Request(val data:RequestsRepository ): ListRequestRepository()

}