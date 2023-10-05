package com.example.team99

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.team99.Home.HomeFragment
import com.example.team99.Home.VideoItem
import com.example.team99.MyVideoFragment.View.MyVideoFragment
import com.example.team99.Search.SearchFragment
import com.example.team99.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
//    private lateinit var viewModel : HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationItemSelect()

//        binding.viewModel = viewModel
//        binding.recycleOwner = this
//
//        setView()
//        setObserver()

//        // 플로팅 버튼
//        binding.fabMain.setOnClickListener {
//            // 플로팅 버튼 클릭시 애니메이션 동작 기능
//            toggleFab()
//
//            // 플로팅 버튼 클릭 이벤트 - 글 쓰기
//            binding.fabEdit.setOnClickListener {
//                val intent = Intent(this, WriteBoardActivity::class.java)
//                startActivity(intent)
//
////              Toast.makeText(this, "글 쓰기 버튼 클릭", Toast.LENGTH_SHORT).show()
//            }
//        }

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
//    private fun setView(){
//        retrofitAdapter =  BoardRecyclerAdapter().apply {
//            setHasStableIds(true) // 리사이클러 뷰 업데이트 시 깜빡임 방지
//        }
//        binding.rvList.adapter = retrofitAdapter // 리사이클러 뷰 연결
//    }
//
//    private fun setObserver() {
//
//        // 뷰모델 관찰
//        viewModel.retrofitTodoList.observe(this, {
//            viewModel.retrofitTodoList.value?.let { it1 -> retrofitAdapter.setData(it1) }
//        })
//
//    }

//    private fun toggleFab() {
//
//        // 플로팅 액션 버튼 닫기 - 열려있는 플로팅 버튼 집어넣는 애니메이션
//        if (isFabOpen) {
//            ObjectAnimator.ofFloat(binding.fabEdit, "translationY", 0f).apply { start() }
//        } else { // 플로팅 액션 버튼 열기 - 닫혀있는 플로팅 버튼 꺼내는 애니메이션
//            ObjectAnimator.ofFloat(binding.fabEdit, "translationY", -250f).apply { start() }
//        }
//
//    isFabOpen = !isFabOpen
//    }

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

