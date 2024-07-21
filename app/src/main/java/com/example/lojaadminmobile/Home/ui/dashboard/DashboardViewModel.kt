package com.example.lojaadminmobile.Home.ui.dashboard

import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    fun getData() :DashBoardRepository.DashboardRequest
    {
        val data:DashBoardRepository.DashboardRequest =DashBoardRepository.DashboardRequest(
                    listDashboard_monthRequests = (
                    listOf(
                        DashBoardRepository.Tuple("1", 10F),
                        DashBoardRepository.Tuple("2", 10F),
                        DashBoardRepository.Tuple("3", 10F),
                        DashBoardRepository.Tuple("4", 10F),
                        DashBoardRepository.Tuple("5", 10F),
                        DashBoardRepository.Tuple("6", 10F),
                        DashBoardRepository.Tuple("7", 10F),
                        DashBoardRepository.Tuple("8", 10F),
                        DashBoardRepository.Tuple("9", 10F),
                        DashBoardRepository.Tuple("10", 10F),
                        DashBoardRepository.Tuple("11", 10F),
                        DashBoardRepository.Tuple("12", 10F),
                        DashBoardRepository.Tuple("13", 10F),
                        DashBoardRepository.Tuple("14", 10F),
                        DashBoardRepository.Tuple("15", 10F),
                        DashBoardRepository.Tuple("16", 10F),
                        DashBoardRepository.Tuple("17", 10F),
                        DashBoardRepository.Tuple("18", 10F),
                        DashBoardRepository.Tuple("19", 10F),
                        DashBoardRepository.Tuple("20", 10F),
                        DashBoardRepository.Tuple("21", 10F),
                        DashBoardRepository.Tuple("22", 10F),
                        DashBoardRepository.Tuple("23", 10F),
                        DashBoardRepository.Tuple("24", 10F),
                        DashBoardRepository.Tuple("25", 10F),
                        DashBoardRepository.Tuple("26", 10F),
                        DashBoardRepository.Tuple("27", 10F),
                        DashBoardRepository.Tuple("28", 10F),
                        DashBoardRepository.Tuple("29", 10F),
                        DashBoardRepository.Tuple("30", 10F),
                        DashBoardRepository.Tuple("31", 10F)
                    )
                ),
            listDashboard_monthRevenue = (
                    listOf(
                        DashBoardRepository.Tuple("1", 10F),
                        DashBoardRepository.Tuple("2", 10F),
                        DashBoardRepository.Tuple("3", 10F),
                        DashBoardRepository.Tuple("4", 10F),
                        DashBoardRepository.Tuple("5", 10F),
                        DashBoardRepository.Tuple("6", 10F),
                        DashBoardRepository.Tuple("7", 10F),
                        DashBoardRepository.Tuple("8", 10F),
                        DashBoardRepository.Tuple("9", 10F),
                        DashBoardRepository.Tuple("10", 10F),
                        DashBoardRepository.Tuple("11", 10F),
                        DashBoardRepository.Tuple("12", 10F),
                        DashBoardRepository.Tuple("13", 10F),
                        DashBoardRepository.Tuple("14", 10F),
                        DashBoardRepository.Tuple("15", 10F),
                        DashBoardRepository.Tuple("16", 10F),
                        DashBoardRepository.Tuple("17", 10F),
                        DashBoardRepository.Tuple("18", 10F),
                        DashBoardRepository.Tuple("19", 10F),
                        DashBoardRepository.Tuple("20", 10F),
                        DashBoardRepository.Tuple("21", 10F),
                        DashBoardRepository.Tuple("22", 10F),
                        DashBoardRepository.Tuple("23", 10F),
                        DashBoardRepository.Tuple("24", 10F),
                        DashBoardRepository.Tuple("25", 10F),
                        DashBoardRepository.Tuple("26", 10F),
                        DashBoardRepository.Tuple("27", 10F),
                        DashBoardRepository.Tuple("28", 10F),
                        DashBoardRepository.Tuple("29", 10F),
                        DashBoardRepository.Tuple("30", 10F),
                        DashBoardRepository.Tuple("31", 10F)
                    )
                    )
        )
        return data
    }
}
