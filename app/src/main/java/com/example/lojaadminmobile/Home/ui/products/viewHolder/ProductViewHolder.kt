package com.example.lojaadminmobile.Home.ui.products.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.lojaadminmobile.R

class ProductViewHolder(private val containerView: View, onClickListener: View.OnClickListener)
{
    private val productImage:ImageView by lazy { containerView.findViewById(R.id.product_image) }
    private val productName:TextView by lazy { containerView.findViewById(R.id.product_name)}
    private val productCategory:TextView by lazy { containerView.findViewById(R.id.product_category) }
    private val productDescription:TextView by lazy { containerView.findViewById(R.id.product_description)}
    private val productSky:TextView by lazy { containerView.findViewById(R.id.product_sku)}
}