package com.example.lojaadminmobile.Home.ui.products

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.products.viewHolder.ListProductsViewHolder
import com.example.lojaadminmobile.Home.ui.products.viewHolder.ProductViewHolder
import com.example.lojaadminmobile.R

private const val VIEW_TYPE_PRODUCT = 0
class ListProductsAdapter(
    private val layoutInflater: LayoutInflater,
    private val onClickListener:OnClickListener,
    private val context: Context
) : RecyclerView.Adapter<ListProductsViewHolder>(){
    private val listData = mutableListOf<ListProductRepository>()
    val swipeToDeleteCallback = SwipeToDeleteCallBack()
    fun setData(newListData: List<ListProductRepository>) {
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
            ProductViewHolder(
                view ,
                object: ProductViewHolder.OnClickListener{
                    override fun onClick(product: ProductsRepository) {
                        onClickListener.onItemClick(product)
                    }
                },
                context

            )
        }
    else -> throw IllegalArgumentException("Wrong view type :$viewType")
    }
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    override fun onBindViewHolder(holder: ListProductsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    inner class SwipeToDeleteCallBack:ItemTouchHelper.SimpleCallback( 0 , ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT )
    {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = false
        override fun getMovementFlags( recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) = if( viewHolder is ProductViewHolder)
        {
            makeMovementFlags( ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) or
            makeMovementFlags( ItemTouchHelper.ACTION_STATE_SWIPE,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        }
        else
        {
            0
        }
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            removeItem(position)
        }
    }
    interface OnClickListener {
        fun onItemClick( product: ProductsRepository)
    }
}