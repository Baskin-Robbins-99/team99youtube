package com.example.team99

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.team99.Home.HomeFragment
import com.example.team99.Home.VideoItem
import com.example.team99.MyVideoFragment.View.MyVideoFragment
import com.example.team99.Search.SearchFragment
import com.example.team99.databinding.ActivityMainBinding
import com.google.gson.Gson
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
        fun saveSelectedItem(context: Context,  items: List<VideoItem>) {
            val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = GsonBuilder().create()
            val jsonItem = gson.toJson(items)
            editor.putString("selectedVideoItem", jsonItem)
            editor.apply()
        }

        fun getSelectedItem(context: Context, item: VideoItem): ArrayList<VideoItem>{
            val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val allEntries: Map<String, *> = sharedPreferences.all
            val clickitem = ArrayList<VideoItem>()
            val prefenceString = sharedPreferences.getString(item.title, null)
            val gson = Gson()
            for ((key, value) in allEntries) {
                val item = gson.fromJson(value as String, VideoItem::class.java)
                clickitem.add(item)
            }
            return clickitem
        }
        fun deleteItem(context: Context, title:String) {
            val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove(title)
            editor.apply()
        }

    }
}

