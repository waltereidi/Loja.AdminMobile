package com.example.lojaadminmobile.Home.ui.requests.viewHolder

import android.content.Context
import android.view.View
import com.example.lojaadminmobile.Home.ui.requests.requestDetails.ListRequestProductsRepository
import com.example.lojaadminmobile.Home.ui.requests.requestDetails.RequestsProductsRepository
import di.DependencyInjection

class RequestProductsViewHolder(private val containerView: View, private val onClickListener: OnClickListener, private val context: Context) : ListRequestsProductsViewHolder(containerView)
{
    private val di:DependencyInjection = DependencyInjection()
    override fun bindData(listRequests: ListRequestProductsRepository )
    {

        require( listRequests is ListRequestProductsRepository.Request)
        val requestData =listRequests.data

        containerView.setOnClickListener { onClickListener.onClick(requestData) }


    }
    interface OnClickListener {
        fun onClick(request: RequestsProductsRepository)
    }




}

