package com.example.lojaadminmobile.Home.ui.requests.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.requests.ListRequestRepository

abstract class ListRequestsViewHolder(containerView: View ) :RecyclerView.ViewHolder(containerView)
{
    abstract  fun bindData(listRequests: ListRequestRepository)
}