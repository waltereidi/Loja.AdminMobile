package com.example.lojaadminmobile.Home.ui.products

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.products.ProductDetails.ui.theme.ProductDetailActivity
import com.example.lojaadminmobile.databinding.FragmentProductsBinding

class ProductsFragment() : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!
    private val listProductAdaper by lazy {
        ListProductsAdapter(
            layoutInflater,
            object: ListProductsAdapter.OnClickListener
            {
                override fun onItemClick(product: ProductsRepository) = openProductDetail(product)
            }
            , context )
    }
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)

        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView:RecyclerView = binding.productsRecyclerView
        recyclerView.adapter = listProductAdaper
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL ,false )
        //val itemTouchHelper = ItemTouchHelper( listProductAdaper.swipeToDeleteCallback )
        //itemTouchHelper.attachToRecyclerView(recyclerView)
        productsViewModel.getListData( listProductAdaper )

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun openProductDetail(product: ProductsRepository) {
        val intent = Intent(context , ProductDetailActivity::class.java )
        intent.putExtra("ean" ,product.ean )
        intent.putExtra("sku" ,product.sku )
        startActivity(intent)
    }

}