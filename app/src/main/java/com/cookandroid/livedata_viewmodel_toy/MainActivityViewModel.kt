package com.cookandroid.livedata_viewmodel_toy

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS,MINUS
}

class MainActivityViewModel(application: Application) : AndroidViewModel(application){


    companion object{
        const val TAG:String = "로그"
    }
    val mApplication = application

    private val _currentValue=MutableLiveData<String>()
    private val _inputValue=MutableLiveData<String>()

    val currentValue:MutableLiveData<String>
        get()=_currentValue

    val inputValue:MutableLiveData<String>
        get()=_inputValue


    //currentValue초기값 설정
    init {
        Log.d(TAG,"MainActivityViewModel - 생성자 호출")
        _currentValue.value="0"
        _inputValue.value="0"
    }

    //더하기 버튼이 눌렸을 때 실행
    fun onClickPlusButton(){
        _currentValue.value= _currentValue.value?.toInt()?.plus(_inputValue.value!!.toInt()).toString()
    }

    //빼기 버튼이 눌렸을 때 실행
    fun onClickMinusButton() {
        _currentValue.value =
            _currentValue.value?.toInt()?.minus(_inputValue.value!!.toInt()).toString()
    }
}