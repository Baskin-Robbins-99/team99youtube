package com.example.team99

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.team99.Home.HomeFragment
import com.example.team99.Home.Items.VideoItem
import com.example.team99.MyVideoFragment.View.MyVideoFragment
import com.example.team99.Search.SearchFragment
import com.example.team99.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationItemSelect()


    }

    private fun navigationItemSelect(){
        binding.mainNav.run {
            setOnItemReselectedListener {
                    item ->
                when(item.itemId){
                    R.id.item_home -> replaceFragment(HomeFragment())
                    R.id.item_my_video -> replaceFragment(MyVideoFragment())
                    R.id.item_search ->replaceFragment(SearchFragment())
                }
                true
            }
            selectedItemId = R.id.item_home
        }
        replaceFragment(fragment = HomeFragment())
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame, fragment)
        fragmentTransaction.commit()
    }

    companion object{

        private const val PREF_NAME = "MyAppPreferences"
        private const val KEY_DATA = "MyKey"
        fun saveSelectedItem(context: Context, items: VideoItem) {
            val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = GsonBuilder().create()
            val jsonItem = gson.toJson(items)
            editor.putString(items.title, jsonItem)
            editor.apply()
            //정보를 줄 때와 받을 때 같은 데이터 타입으로 해줘야한다.
        }

        fun getPrefBookmarkItems(context: Context): ArrayList<VideoItem> {
            val prefs = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE)
            val allEntries: Map<String, *> = prefs.all
            val bookmarkItems = ArrayList<VideoItem>()
            val gson = GsonBuilder().create()
            for ((key, value) in allEntries) {
                val item = gson.fromJson(value as String, VideoItem::class.java)
                bookmarkItems.add(item)
            }
            Log.d("red", bookmarkItems.toString())
            return bookmarkItems
        }
        fun deleteItem(context: Context, title:String) {
            val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove(title)
            editor.apply()
        }

    }
}

