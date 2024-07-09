package com.example.lojaadminmobile.Home.ui.requests.viewHolder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.lojaadminmobile.Home.ui.requests.ListRequestRepository
import com.example.lojaadminmobile.Home.ui.requests.RequestsRepository
import com.example.lojaadminmobile.R
import di.DependencyInjection

class RequestViewHolder(private val containerView: View, private val onClickListener: OnClickListener, private val context: Context) : ListRequestsViewHolder(containerView)
{
    private val di:DependencyInjection = DependencyInjection()
    private val requestImage: ImageView by lazy { containerView.findViewById(R.id.request_image)}
    private val requestClientName: TextView by lazy { containerView.findViewById(R.id.request_clientName)}
    private val requestId: TextView by lazy { containerView.findViewById(R.id.request_id) }
    private val requestDescription: TextView by lazy { containerView.findViewById(R.id.request_description) }
    private val requestDate: TextView by lazy { containerView.findViewById(R.id.request_date) }
    override fun bindData(listRequests: ListRequestRepository )
    {

        require( listRequests is ListRequestRepository.Request)
        val requestData =listRequests.data

        containerView.setOnClickListener { onClickListener.onClick(requestData) }
        di.loadImage(context, requestData.imageUrl, requestImage)
        requestClientName.text = requestData.clientName
        requestId.text = requestData.id.toString()
        requestDescription.text = requestData.description
        requestDate.text = requestData.date.toString()


    }
    interface OnClickListener {
        fun onClick(request: RequestsRepository)
    }




}

