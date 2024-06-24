package com.example.lojaadminmobile.Home.ui.products.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.products.ListProductRepository


abstract class ListProductViewHolder(containerView: View): RecyclerView.ViewHolder(containerView)
{
    abstract fun bindData(listItem:ListProductRepository)
}