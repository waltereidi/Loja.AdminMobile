package com.example.lojaadminmobile.Home.ui.products.ProductDetails

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.lojaadminmobile.Home.ui.products.ProductDetails.ui.theme.ProductDetailRepository
import com.example.lojaadminmobile.Home.ui.products.ProductDetails.ui.theme.ProductDetailViewModel
import com.example.lojaadminmobile.R
import di.DependencyInjection

class ProductDetailActivity : AppCompatActivity() {
    private val di: DependencyInjection = DependencyInjection()

    private val productDetailImage: ImageView by lazy { findViewById(R.id.productDetail_imageView) }
    private val productDetailName: TextView by lazy { findViewById(R.id.productDetail_nameTextViewValue) }
    private val productDetailSku: TextView by lazy { findViewById(R.id.productDetail_skuTextViewValue) }
    private val productDetailEan: TextView by lazy { findViewById(R.id.productDetail_eanTextViewValue) }
    private val productDetailPrice: TextView by lazy { findViewById(R.id.productDetail_priceTextViewValue) }
    private val productDetailDescription: TextView by lazy { findViewById(R.id.productDetail_DescriptionTextViewValue) }
    private val productDetailCategory: TextView by lazy { findViewById(R.id.productDetail_categoryTextViewValue) }
    private val productDetailCreatedAt: TextView by lazy { findViewById(R.id.productDetail_createdAtTextViewValue) }
    private val productDetailUpdatedAt: TextView by lazy { findViewById(R.id.productDetail_updatedAtTextViewValue) }
    private val viewModel: ProductDetailViewModel get()= ViewModelProvider(this).get(ProductDetailViewModel::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_product_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.productDetail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setData()
        val sku:String?=intent.getStringExtra("sku")
        val ean:String?=intent.getStringExtra("ean")
        if(sku.isNullOrBlank() && ean.isNullOrBlank())
        {
            finish()
        }
    }
    fun setData(){
        val dataSource: ProductDetailRepository = viewModel.getData()
        productDetailName.text=dataSource.name
        productDetailSku.text=dataSource.sku
        productDetailEan.text=dataSource.ean
        productDetailPrice.text=dataSource.price.toString()
        productDetailDescription.text=dataSource.description
        productDetailCategory.text=dataSource.category
        productDetailCreatedAt.text=dataSource.createdAt.toString()
        productDetailUpdatedAt.text=dataSource.updatedAt.toString()
        di.loadImage(this , dataSource.imageUrl, productDetailImage)

    }
}
