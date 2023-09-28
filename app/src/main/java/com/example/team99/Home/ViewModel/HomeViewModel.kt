//package com.example.team99.Home.ViewModel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.team99.Home.HomeRepository.HomeRepository
//import kotlinx.coroutines.launch
//
//class HomeViewModel(private val repository: HomeRepository): ViewModel() {
//    private val _retrofitTodoList = MutableLiveData<ExDataClass>()
//    // MutableLiveData - 수정 가능
//    // LiveData - 값 수정 불가능
//
//    // 내부에서 설정하는 자료형은 Mutable로 변경가능하도록 설정한다.
//    val retrofitTodoList: MutableLiveData<ExDataClass>
//        get() = _retrofitTodoList
//    // 뷰모델이 생성될 때 초기값 설정해준다.
//
//    init{
//        //LiveData로 맵핑이 되어있을때 값을 수정하려면 value를 이용한다.
//        //LivaData로는 값 수정이 불가능 하지만 MutableLiveData로 초기화 했기 때문에 수정이 가능하다.
//        viewModelScope.launch {
//            _retrofitTodoList.value = repository.retrofitSelectAllTodo()
//        }
//    }
//
//    //insert
//    fun insertRetrofit(title : String, contents : String) = viewModelScope.launch {
//        val response = repository.retrofitInsertTodo(ModelBoardComponent(title, contents))
//        if (response.isSuccessful) _retrofitTodoList.value = repository.retrofitSelectAllTodo()
//    }
//
//    // 하나의 팩토리로 다양한 ViewModel 클래스를 관리할 수도 있고, 원치 않는 상황에 대해서 컨트롤 할 수 있다.
//    class Factory(private val application : Application) : ViewModelProvider.Factory { // factory pattern
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            return MainViewModel(BoardRepository.getInstance(application)!!) as T
//        }
//    }
//
//
//}