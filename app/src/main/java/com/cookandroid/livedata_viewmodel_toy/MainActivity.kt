package com.cookandroid.livedata_viewmodel_toy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cookandroid.livedata_viewmodel_toy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val TAG:String = "로그"
    }

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.currentValue.observe(this, Observer {
            Log.d(TAG,"MainActivity - mainActivityViewModel - currentValue 라이브 데이터 값 변경 : $it")
            findViewById<TextView>(R.id.tx).text=it.toString()
        })
        findViewById<Button>(R.id.plus_btn).setOnClickListener(this)
        findViewById<Button>(R.id.minus_btn).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val userInput = findViewById<EditText>(R.id.edt).text.toString().toInt()

        when(v){
            findViewById<Button>(R.id.plus_btn)->{
                mainActivityViewModel.updateValue(actionType = ActionType.PLUS,userInput)
            }
            findViewById<Button>(R.id.minus_btn)->{
                mainActivityViewModel.updateValue(actionType = ActionType.MINUS,userInput)
            }
        }
    }
}