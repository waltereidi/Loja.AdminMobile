package com.example.lojaadminmobile.Home

import android.content.Intent
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.products.ListProductRepository
import com.example.lojaadminmobile.Home.ui.products.ListProductsAdapter
import com.example.lojaadminmobile.Home.ui.products.ProductDetails.ui.theme.ProductDetailActivity
import com.example.lojaadminmobile.Home.ui.products.ProductsRepository
import com.example.lojaadminmobile.Home.ui.products.ProductsViewModel
import com.example.lojaadminmobile.R

class ProductsFragmentExtension : HomeActivity()
{

    ///Products
    private val productsViewModel: ProductsViewModel = ProductsViewModel()
    private val productRecyclerView: RecyclerView by lazy { findViewById(R.id.products_recycler_view)}
    private val listProductAdaper by lazy {
        ListProductsAdapter(
            layoutInflater,
            object: ListProductsAdapter.OnClickListener
            {
                override fun onItemClick(product: ProductsRepository) =openProductDetail(product)
            }
            ,this )
    }
    fun render()
    {
        productRecyclerView.adapter = listProductAdaper
        productRecyclerView.layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL ,false )
        val itemTouchHelper = ItemTouchHelper(listProductAdaper.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(productRecyclerView)
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
    private fun openProductDetail(product: ProductsRepository) {

        val intent = Intent(this , ProductDetailActivity::class.java )
        intent.putExtra("ean" ,product.ean )
        intent.putExtra("sku" ,product.sku )
        startActivity(intent)
    }
}