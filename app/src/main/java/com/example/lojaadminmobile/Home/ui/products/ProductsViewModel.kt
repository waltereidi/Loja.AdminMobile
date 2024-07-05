package com.example.lojaadminmobile.Home.ui.products

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.HomeActivity

class ProductsViewModel(
    private val recyclerView: RecyclerView,
    private val listProductAdaper: ListProductsAdapter,
    private val context: HomeActivity
) : ViewModel() {
         fun render()
    {
        recyclerView.adapter = listProductAdaper
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL ,false )
        val itemTouchHelper = ItemTouchHelper(listProductAdaper.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        Log.d(ContentValues.TAG,"created" )
        listProductAdaper.setData(
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