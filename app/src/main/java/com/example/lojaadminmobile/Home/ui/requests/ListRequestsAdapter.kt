package com.example.lojaadminmobile.Home.ui.requests

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.requests.viewHolder.ListRequestsViewHolder
import com.example.lojaadminmobile.Home.ui.requests.viewHolder.RequestViewHolder
import com.example.lojaadminmobile.R

private const val VIEW_TYPE_PRODUCT = 0
class ListRequestsAdapter(
    private val layoutInflater: LayoutInflater,
    private val onClickListener:OnClickListener,
    private val context: Context?
) : RecyclerView.Adapter<ListRequestsViewHolder>(){
    private val listData = mutableListOf<ListRequestRepository>()
    fun setData(newListData: List<ListRequestRepository>) {
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
    fun removeItem(position: Int) {
        listData.removeAt(position)
        notifyItemRemoved(position)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        VIEW_TYPE_PRODUCT ->{
            val view= layoutInflater.inflate(R.layout.activity_product_view_holder , parent , false)
            RequestViewHolder(
                view ,
                object: RequestViewHolder.OnClickListener{
                    override fun onClick(request: RequestsRepository) {
                        onClickListener.onItemClick(request)
                    }
                },
                context!!

            )
        }
    else -> throw IllegalArgumentException("Wrong view type :$viewType")
    }
    override fun getItemCount() = listData.size
    override fun onBindViewHolder(holder: ListRequestsViewHolder, position: Int) {
        holder.bindData(listData[position])
    }

    interface OnClickListener {
        fun onItemClick( product: RequestsRepository)
    }
}