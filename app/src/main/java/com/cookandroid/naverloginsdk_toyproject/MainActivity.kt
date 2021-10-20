package com.cookandroid.naverloginsdk_toyproject

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import com.nhn.android.naverlogin.OAuthLogin
import com.nhn.android.naverlogin.OAuthLoginHandler
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var mOAuthLoginInstance = OAuthLogin.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mOAuthLoginInstance.init(this, "ocHtoahCwyIiavMBEr0K", "VocqkjAIW9", "knowing")
        var handler = Handler(Looper.getMainLooper())

        findViewById<Button>(R.id.btn_naver_login).setOnClickListener {


            mOAuthLoginInstance.logoutAndDeleteToken(this)
            //startOauthLoginActivity를 쓰레드로 묶으면 로그인 할 때 체크하는 정보가 나오는데 안하면 안나옴
            mOAuthLoginInstance.startOauthLoginActivity(this, mOAuthLoginHandler)


        }
    }
    //onCreate 밖에 핸들러를 설정해야지 된다. oncreate안에다가 선언했더니 handler가 안되서 삽질 함.
    val mOAuthLoginHandler = object : OAuthLoginHandler() {
        override fun run(success: Boolean) {
            if (success) {
                var accessToken = mOAuthLoginInstance.getAccessToken(this@MainActivity)
                println("토큰 값:" + mOAuthLoginInstance.getAccessToken(this@MainActivity).toString())
                println("성공")
                findViewById<TextView>(R.id.tx).text =
                    mOAuthLoginInstance.getAccessToken(this@MainActivity).toString()

                var header = "Bearer " + accessToken
                var requestHeaders = HashMap<String,String>()
                requestHeaders.put("Authorization",header)
                var apiURL = "https://openapi.naver.com/v1/nid/me"

            } else {
                println("로그인 실패")
            }
        }
    }

}