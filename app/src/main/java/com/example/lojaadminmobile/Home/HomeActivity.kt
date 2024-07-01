package com.example.lojaadminmobile.Home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.products.ListProductRepository
import com.example.lojaadminmobile.Home.ui.products.ListProductsAdapter
import com.example.lojaadminmobile.Home.ui.products.ProductDetails.ui.theme.ProductDetailActivity
import com.example.lojaadminmobile.Home.ui.products.ProductsRepository
import com.example.lojaadminmobile.R
import com.example.lojaadminmobile.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val recyclerView:RecyclerView by lazy { findViewById(R.id.products_recycler_view)}
    private val listProductAdaper by lazy {
        ListProductsAdapter(
            layoutInflater,
            object: ListProductsAdapter.OnClickListener{
                override fun onItemClick(product: ProductsRepository) =showSelectionDialog(product)
            },
            this
        )

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(com.example.lojaadminmobile.R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration( setOf( com.example.lojaadminmobile.R.id.navigation_products, com.example.lojaadminmobile.R.id.navigation_dashboard, com.example.lojaadminmobile.R.id.navigation_requests ) )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        recyclerView.adapter = listProductAdaper
        recyclerView.layoutManager =LinearLayoutManager(this , LinearLayoutManager.VERTICAL ,false )
        val itemTouchHelper = ItemTouchHelper(listProductAdaper.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
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
                ),
                ListProductRepository.Product(
                    ProductsRepository(
                        "Title",
                        "",
                        "",
                        "",
                        "",
                        ""
                    ),
                ),
                ListProductRepository.Product(
                    ProductsRepository(
                        "Title",
                        "",
                        "",
                        "",
                        "",
                        ""
                    ),
                ),
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
    private fun showSelectionDialog(product: ProductsRepository) {

        val intent = Intent(this , ProductDetailActivity::class.java )
        intent.putExtra("ean" ,product.ean )
        intent.putExtra("sku" ,product.sku )
        startActivity(intent)
    }
}