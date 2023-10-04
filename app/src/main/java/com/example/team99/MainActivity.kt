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
//    private lateinit var viewModel : HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationItemSelect()
//        db = FirebaseFirestore.getInstance()
//        storge = Firebase.storage

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
//        private const val KEY_ITEM = "selectedItem" 키는 item의 title로 바꿈
        //리스트 타입으로 넣어야한다. 기존의 값과
        fun saveSelectedItem(context: Context,  items: List<VideoItem>) {
            val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = GsonBuilder().create()
            val jsonItem = gson.toJson(items)
            editor.putString("selectedVideoItem", jsonItem)
            editor.apply()
            //정보를 줄 때와 받을 때 같은 데이터 타입으로 해줘야한다.
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

