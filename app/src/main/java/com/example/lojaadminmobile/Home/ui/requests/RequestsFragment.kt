package com.example.lojaadminmobile.Home.ui.requests

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lojaadminmobile.databinding.FragmentRequestsBinding

class RequestsFragment : Fragment() {

    private var _binding: FragmentRequestsBinding? = null
    private val binding get() = _binding!!
    private val listRequestAdaper by lazy {
        ListRequestsAdapter(
            layoutInflater,
            object: ListRequestsAdapter.OnClickListener
            {
                override fun onItemClick(request: RequestsRepository) = openRequestDetail(request)
            }
            , context )
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val requestsViewModel = ViewModelProvider(this).get(RequestsViewModel::class.java)

        _binding = FragmentRequestsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView = binding.requestsRecyclerView
        recyclerView.adapter = listRequestAdaper
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL ,false )

        requestsViewModel.getListData( listRequestAdaper )

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun openRequestDetail( request: RequestsRepository) {
        val intent = Intent(context , RequestDetailActivity::class.java )
        startActivity(intent)
    }
}