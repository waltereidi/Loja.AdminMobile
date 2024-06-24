package com.example.lojaadminmobile.Home.ui.products

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ListProductsViewHolder(containerView: View ) :RecyclerView.ViewHolder(containerView)
{
    abstract  fun bindData(listProducts: ListProductsViewHolder)
}