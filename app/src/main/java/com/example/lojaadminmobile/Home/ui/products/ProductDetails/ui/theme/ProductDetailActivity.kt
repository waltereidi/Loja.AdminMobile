package com.example.lojaadminmobile.Home.ui.products.ProductDetails

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lojaadminmobile.R
class ProductDetailActivity : AppCompatActivity() {
    private val productDetailImage: ImageView by lazy { findViewById(R.id.productDetail_imageView) }
    private val productDetailName: TextView by lazy { findViewById(R.id.productDetail_nameTextViewValue) }
    private val productDetailSku: TextView by lazy { findViewById(R.id.productDetail_skuTextViewValue) }
    private val productDetailEan: TextView by lazy { findViewById(R.id.productDetail_eanTextViewValue) }
    private val productDetailPrice: TextView by lazy { findViewById(R.id.productDetail_priceTextViewValue) }
    private val productDetailDescription: TextView by lazy { findViewById(R.id.productDetail_DescriptionTextViewValue) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_product_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.productDetail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sku:String?=intent.getStringExtra("sku")
        val ean:String?=intent.getStringExtra("ean")
        if(sku.isNullOrBlank() && ean.isNullOrBlank())
        {
            finish()
        }

    }
}
