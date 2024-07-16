package com.example.lojaadminmobile.Home.ui.requests
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lojaadminmobile.Home.ui.requests.requestDetails.ListRequestsProductsAdapter
import com.example.lojaadminmobile.Home.ui.requests.requestDetails.RequestDetailViewModel
import com.example.lojaadminmobile.R

class RequestDetailActivity : AppCompatActivity() {
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

        val viewModel:RequestDetailViewModel = ViewModelProvider(this).get(RequestDetailViewModel::class.java)
        setContentView(R.layout.activity_request_detail)

        recyclerView.adapter = listRequestProductAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.getListData(listRequestProductAdapter)

        //var detailData = viewModel.getDetailData(intent.getStringExtra("id")!!.toInt())

    }



}