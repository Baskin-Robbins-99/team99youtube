package com.example.team99.MyVideoFragment.Database

import android.content.Context
import com.example.team99.MainActivity

class SharedPreferences(context: Context){
    private val PREF_NAME = "MyAppPreferences"
    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

}