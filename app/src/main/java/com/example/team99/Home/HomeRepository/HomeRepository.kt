//package com.example.team99.Home.HomeRepository

//import android.app.Application
//import androidx.lifecycle.MutableLiveData

//class HomeRepository(application: Application) {

    //Retrofit 연결

//   suspend fun retrofitSelectAllTodo(): EXDataClass {

//       val response = ObjectClass.getRetrofitService.get인터페이스의 funtion
//              return if (response.isSuccessful) response.body() as EXDataClass else EXDataClass(
//                    ArrayList()
//               )
//   }

    // singleton pattern
    //   companion object {
//  private var instance: HomeRepository? = null

//      fun getInstance(application: Application): HomeRepository? {
//           if (instance == null) instance = HomeRepository(application)
//         return  instance
//      }
//   }
    // Insert
//  suspend fun retrofitInsertTodo(realDataClass: realDataClass) : Response<JsonObject> {
//       return retrofitObject.objectvalService.interface suspendfunPostBoard(realDataClass.title, realDataClass.contents )
//   }



//}