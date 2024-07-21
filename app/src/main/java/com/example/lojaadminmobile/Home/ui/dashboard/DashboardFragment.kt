package com.example.lojaadminmobile.Home.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lojaadminmobile.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val barChart = binding.dashboardMonthRequest
        initCharts()
        return root
    }
    private fun initCharts() {
        val viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        val data:DashBoardRepository.DashboardRequest = viewModel.getData()

        val monthRevenuedashBoard = binding.dashboardMonthRevenue
        val monthRequestsDashBoard = binding.dashboardMonthRequest
        monthRevenuedashBoard.animate(data.listDashboard_monthRevenue.map{it.title to it.value})
        monthRequestsDashBoard.animate(data.listDashboard_monthRequests.map{it.title to it.value})

        monthRequestsDashBoard.animation.duration = 2000
        monthRevenuedashBoard.animation.duration = 2000
    }
     override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}