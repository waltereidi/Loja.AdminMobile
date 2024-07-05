package com.example.lojaadminmobile.Home.ui.products.viewHolder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.lojaadminmobile.Home.ui.products.ListProductRepository
import com.example.lojaadminmobile.Home.ui.products.ProductsRepository
import com.example.lojaadminmobile.R
import di.DependencyInjection

class ProductViewHolder(private val containerView: View,private val onClickListener: OnClickListener ,private val context: Context) : ListProductsViewHolder(containerView)
{
    private val productImage:ImageView by lazy { containerView.findViewById(R.id.product_image) }
    private val productName:TextView by lazy { containerView.findViewById(R.id.product_name)}
    private val productCategory:TextView by lazy { containerView.findViewById(R.id.product_category) }
    private val productDescription:TextView by lazy { containerView.findViewById(R.id.product_description)}
    private val productSku:TextView by lazy { containerView.findViewById(R.id.product_sku)}
    private val di:DependencyInjection = DependencyInjection()

    override fun bindData(listItem:ListProductRepository )
    {
        require(listItem is ListProductRepository.Product)
        val productData =listItem.data

        containerView.setOnClickListener { onClickListener.onClick(productData) }
        di.loadImage(context, productData.imageUrl , productImage )
        productName.text = productData.name
        productCategory.text = productData.category
        productDescription.text = productData.description
        productSku.text = productData.sku
    }
    interface OnClickListener {
        fun onClick(product: ProductsRepository)
    }


}

