package com.example.lojaadminmobile.Home.ui.dashboard

import com.google.gson.annotations.SerializedName
class DashBoardRepository{
    data class DashboardRequest(
        @SerializedName("listDashboard_monthRequests") val listDashboard_monthRequests:List<Tuple>,
        @SerializedName("listDashboard_monthRevenue") val listDashboard_monthRevenue:List<Tuple>,
    )
    data class Tuple(val title:String ,val value:Float);
}


