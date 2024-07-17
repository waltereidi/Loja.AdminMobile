package com.example.lojaadminmobile.Home.ui.requests

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.requests.requestDetails.ListRequestsProductsAdapter
import com.example.lojaadminmobile.Home.ui.requests.requestDetails.RequestDetailRepository
import com.example.lojaadminmobile.Home.ui.requests.requestDetails.RequestDetailViewModel
import com.example.lojaadminmobile.R

class RequestDetailActivity : AppCompatActivity() {
    private val clientName: TextView get()= findViewById(R.id.requestDetail_clientNameValue)
    private val email:TextView get()= findViewById(R.id.requestDetail_clientEmailValue)
    private val address:TextView get()= findViewById(R.id.requestProducts_clientAddressValue)
    private val requestId:TextView get()= findViewById(R.id.requestDetail_clientRequestIdValue)
    private val viewModel: RequestDetailViewModel get()= ViewModelProvider(this).get(RequestDetailViewModel::class.java)

    private val recyclerView: RecyclerView
            by lazy { findViewById(R.id.requestDetail_recycler_view) }
    private val listRequestProductAdapter by lazy {
        ListRequestsProductsAdapter(
            layoutInflater,
            this
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_request_detail)

        recyclerView.adapter = listRequestProductAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        setRequestDetailData()
    }
    private fun setRequestDetailData()
    {
        viewModel.getListData(listRequestProductAdapter)

        val dataSource: RequestDetailRepository = viewModel.getDetailData(1)

        val intentExtras = intent.extras
        clientName.text = dataSource.clientName
        email.text = dataSource.email
        address.text = dataSource.address
        requestId.text = dataSource.requestId.toString()
    }




}