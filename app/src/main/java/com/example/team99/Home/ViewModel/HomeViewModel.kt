package com.example.team99.Home.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(): ViewModel() {

    // 내부에서 설정하는 자료형은 Mutable로 변경가능하도록 설정한다.
    private val _currentValue = MutableLiveData<Int>()
    // MutableLiveData - 수정 가능
    // LiveData - 값 수정 불가능

    val currenValue: LiveData<Int>
        get() = _currentValue
    // 뷰모델이 생성될 때 초기값 설정해준다.

    init{
        //LiveData로 맵핑이 되어있을때 값을 수정하려면 value를 이용한다.
        //LivaData로는 값 수정이 불가능 하지만 MutableLiveData로 초기화 했기 때문에 수정이 가능하다.
        _currentValue.value = 0
    }

}