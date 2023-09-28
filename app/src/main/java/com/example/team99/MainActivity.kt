package com.example.team99

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.team99.MyVideoFragment.View.MyVideoFragment
import com.example.team99.Home.HomeFragment
import com.example.team99.databinding.ActivityMainBinding

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
}

