package com.example.lojaadminmobile.Home.ui.products

import androidx.lifecycle.ViewModel

class ProductsViewModel() : ViewModel()
{
    fun getListData(listProductsAdapter: ListProductsAdapter)
    {
        listProductsAdapter.setData(
            listOf(
                ListProductRepository.Product(
                    ProductsRepository(
                        "Kitties",
                        "CatProduct",
                        "999898",
                        "0009990",
                        "https://www.vetstreet.com/wp-content/uploads/2022/09/shutterstock_772334182.jpg",
                        "Cuties"
                    ),
                )
            )
        )
    }


}