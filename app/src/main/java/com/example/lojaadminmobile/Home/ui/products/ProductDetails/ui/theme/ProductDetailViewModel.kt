package com.example.lojaadminmobile.Home.ui.products.ProductDetails.ui.theme

import androidx.lifecycle.ViewModel
import java.util.Date

class ProductDetailViewModel : ViewModel() {
    fun getData() : ProductDetailRepository {
        val  data:ProductDetailRepository = ProductDetailRepository(
            "Cats" ,
            "Cat food" ,
            "00010101" ,
            "01010101" ,
            "https://www.vetstreet.com/wp-content/uploads/2022/09/shutterstock_772334182.jpg",
            "Cats",
            Date() ,
            Date() ,
            1 ,
            1212.toDouble(),
        )
        return data
    }

}