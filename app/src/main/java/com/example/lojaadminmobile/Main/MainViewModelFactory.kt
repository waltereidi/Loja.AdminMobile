package com.example.lojaadminmobile.Main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainViewModelFactory constructor( private val application: Application ): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass)
        {
            when
            {
                isAssignableFrom(MainViewModel::class.java) -> MainViewModel(application)
                else -> throw IllegalArgumentException("You need to put the same class above to call this factory")
            }
        } as T
}