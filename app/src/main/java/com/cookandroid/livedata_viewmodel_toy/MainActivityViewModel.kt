package com.cookandroid.livedata_viewmodel_toy

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS,MINUS
}

class MainActivityViewModel : ViewModel(){

    companion object{
        const val TAG:String = "로그"
    }

    private val _currentValue=MutableLiveData<Int>()

    val currentValue:MutableLiveData<Int>
        get()=_currentValue


    //currentValue초기값 설정
    init {
        Log.d(TAG,"MainActivityViewModel - 생성자 호출")
        _currentValue.value=0
    }

    fun updateValue(actionType: ActionType,input:Int){
        when(actionType){
            ActionType.PLUS->
                _currentValue.value= _currentValue.value?.plus(input)
            ActionType.MINUS->
                _currentValue.value=_currentValue.value?.minus(input)
        }
    }

}