package com.example.lojaadminmobile.Home.ui.requests.requestDetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.requests.viewHolder.ListRequestsProductsViewHolder
import com.example.lojaadminmobile.Home.ui.requests.viewHolder.RequestProductsViewHolder
import com.example.lojaadminmobile.R

private const val VIEW_TYPE_PRODUCT = 0
class ListRequestsProductsAdapter(
    private val layoutInflater: LayoutInflater,
    private val context: Context
) : RecyclerView.Adapter<ListRequestsProductsViewHolder>(){
    private val listData = mutableListOf<ListRequestProductsRepository>()
    fun setData(newListData: List<ListRequestProductsRepository>) {
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        VIEW_TYPE_PRODUCT ->{
            val view= layoutInflater.inflate(R.layout.activity_requestproducts_view_holder , parent , false)
            RequestProductsViewHolder(
                view ,
                context

            )
        }
    else -> throw IllegalArgumentException("Wrong view type :$viewType")
    }
    override fun getItemCount() = listData.size
    override fun onBindViewHolder(holder: ListRequestsProductsViewHolder, position: Int) {
        holder.bindData(listData[position])
    }

}