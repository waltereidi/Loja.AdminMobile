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
                        "Title",
                        "",
                        "",
                        "",
                        "",
                        ""
                    ),
                )
            )
        )
    }


}