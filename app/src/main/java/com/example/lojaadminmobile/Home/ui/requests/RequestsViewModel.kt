package com.example.lojaadminmobile.Home.ui.requests

import androidx.lifecycle.ViewModel
import java.util.Date

class RequestsViewModel : ViewModel() {
    fun getListData(listRequestAdaper: ListRequestsAdapter) {
        listRequestAdaper.setData(
            listOf(
                ListRequestRepository.Request(
                    RequestsRepository(
                        "https://www.vetstreet.com/wp-content/uploads/2022/09/shutterstock_772334182.jpg",
                        "Alexa Fibbles" ,
                        1,
                        "Cutie cats",
                        Date()
                    ),
                )
            )
        )
    }

}