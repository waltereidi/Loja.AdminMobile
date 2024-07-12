package com.example.lojaadminmobile.Home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lojaadminmobile.R
import com.example.lojaadminmobile.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

open class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    ///DashBoard
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        val appBarConfiguration = AppBarConfiguration( setOf( R.id.navigation_products,R.id.navigation_dashboard, R.id.navigation_requests ) )


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }
    override  fun onResume(){
        super.onResume()
        Log.d(TAG ,"resumed" )
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG ,"stop" )
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG ,"start" )
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG ,"pause" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG ,"destroy" )
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG ,"restart" )
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        Log.d(TAG ,"resumeFragment" )
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_nav_menu, menu)

        return true
    }
}