package com.example.lojaadminmobile.Home.ui.requests.requestDetails

import androidx.lifecycle.ViewModel
import com.example.lojaadminmobile.Home.ui.requests.RequestDetails.ui.theme.RequestDetailRepository

class RequestDetailViewModel : ViewModel() {
    fun getListData(listRequestProductsAdaper: ListRequestsProductsAdapter) {
        listRequestProductsAdaper.setData(
            listOf(
                ListRequestProductsRepository.RequestProduct(
                    RequestsProductsRepository(
                        "Product",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROK4YRMMC2SFQTXh5tQtSRyPKz5K-IUwGfFw&s",
                        "12323",
                        "23123",
                        1212.toDouble(),
                        1
                    )

                ),ListRequestProductsRepository.RequestProduct(
                    RequestsProductsRepository(
                        "Product",
                        "https://cats.com/wp-content/uploads/2023/08/Cheapest-Cat-Foods.jpg",
                        "12323",
                        "23123",
                        1212.toDouble(),
                        1
                    )

                ),
                ListRequestProductsRepository.RequestProduct(
                    RequestsProductsRepository(
                        "Product",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgPKiOU-pbETdo9mk5yEjmiARf3o6TOgi-R2pLzJm_sK7u4nsHCAosg9Hyn6Zr-3vRaaQ&usqp=CAU",
                        "12323",
                        "23123",
                        1212.toDouble(),
                        1
                    )

                )
            )
        )
    }

    fun getDetailData(stringExtra:Int): RequestDetailRepository {
        return RequestDetailRepository(
            1 ,
            "4 items in your request" ,
            100.23.toDouble(),
            "Product",
            "",
            1,
        )

    }

}