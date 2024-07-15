package com.example.lojaadminmobile.Home.ui.requests.viewHolder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.lojaadminmobile.Home.ui.requests.requestDetails.ListRequestProductsRepository
import com.example.lojaadminmobile.R
import di.DependencyInjection

class RequestProductsViewHolder(private val containerView: View,  private val context: Context) : ListRequestsProductsViewHolder(containerView)
{
    private val di:DependencyInjection = DependencyInjection()
    private val requestProductsImage:ImageView by lazy { containerView.findViewById(R.id.requestproduct_image) }
    private val requestProductsName: TextView by lazy { containerView.findViewById(R.id.requestproduct_name) }
    private val requestProductsQuantity: TextView by lazy { containerView.findViewById(R.id.requestproduct_quantity) }
    private val requestProductsPrice: TextView by lazy { containerView.findViewById(R.id.requestproduct_priceValue ) }
    override fun bindData(listRequests: ListRequestProductsRepository )
    {
        require( listRequests is ListRequestProductsRepository.RequestProduct)
        val requestData =listRequests.data

        di.loadImage(context , requestData.productImageUrl, requestProductsImage)
        requestProductsName.text = requestData.name
        requestProductsQuantity.text = requestData.quantity.toString()
        requestProductsPrice.text = requestData.price.toString()
    }

}

