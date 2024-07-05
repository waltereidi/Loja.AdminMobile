package com.example.lojaadminmobile.Home

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.requests.ListRequestsAdapter
import com.example.lojaadminmobile.Home.ui.requests.RequestDetails.ui.theme.RequestDetailActivity
import com.example.lojaadminmobile.Home.ui.requests.RequestsRepository
import com.example.lojaadminmobile.Home.ui.requests.RequestsViewModel
import com.example.lojaadminmobile.R

class RequestsFragmentExtension : HomeActivity()
{
    ///Requests
    private val requestsViewModel: RequestsViewModel = RequestsViewModel()
    private val requestRecyclerView: RecyclerView by lazy { findViewById(R.id.requests_recycler_view )}
    private val listRequestAdaper by lazy {
        ListRequestsAdapter(
            layoutInflater,
            object: ListRequestsAdapter.OnClickListener{
                override fun onItemClick(request: RequestsRepository) = openRequestDetail(request )
            },
            this
        )
    }
    private fun openRequestDetail(requests: RequestsRepository) {
        val intent = Intent(this , RequestDetailActivity::class.java )
        startActivity(intent)
    }
}