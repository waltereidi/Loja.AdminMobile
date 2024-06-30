package com.example.lojaadminmobile.Home.ui.requests.viewHolder

import android.content.Context
import android.view.View
import com.example.lojaadminmobile.Home.ui.requests.ListRequestRepository
import com.example.lojaadminmobile.Home.ui.requests.RequestsRepository
import di.DependencyInjection

class RequestViewHolder(private val containerView: View, private val onClickListener: OnClickListener, private val context: Context) : ListRequestsViewHolder(containerView)
{
    private val di:DependencyInjection = DependencyInjection()
    override fun bindData(listRequests: ListRequestRepository )
    {

        require( listRequests is ListRequestRepository.Request)
        val requestData =listRequests.data

        containerView.setOnClickListener { onClickListener.onClick(requestData) }


    }
    interface OnClickListener {
        fun onClick(request: RequestsRepository)
    }




}

