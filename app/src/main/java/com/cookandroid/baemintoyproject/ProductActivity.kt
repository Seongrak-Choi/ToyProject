package com.cookandroid.baemintoyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.cookandroid.baemintoyproject.databinding.ActivityProductBinding
import com.google.android.material.appbar.AppBarLayout

class ProductActivity : AppCompatActivity() {

    private var imgList = ArrayList<Int>()
    private lateinit var binding : ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        var result =0 //statusbar 높이를 저장할 변수
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android") //사실 잘 모르겠다. statusbar의 resourceId값을 구하는 코드인거 같다.

        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId) //reuslt에 statusbar 높이를 저장한다.
        }

        imgList.add(R.drawable.img1)
        imgList.add(R.drawable.img2)
        imgList.add(R.drawable.img3)


        //statusbar를 투명하게 만드는 코드
        val window = window
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        //viewpager 어댑터 장착
        binding.viewpager2.adapter = ViewPager2Adapter(imgList)
        binding.viewpager2.orientation=ViewPager2.ORIENTATION_HORIZONTAL


        binding.toolbar.setPadding(0,result+20,0,20,)


        //appbar offsetchange리스너
        binding.appbar.addOnOffsetChangedListener(object:AppBarLayout.OnOffsetChangedListener{
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                Log.d("offset",verticalOffset.toString())
                if (appBarLayout != null) {
                    if(verticalOffset<-1265){
                        binding.toolbar.setBackgroundDrawable(ContextCompat.getDrawable(this@ProductActivity,R.color.white))
                        binding.arrow.setImageResource(R.drawable.ic_baseline_arrow_back_24)
                        binding.productInfoBtnCart.setImageResource(R.drawable.ic_baseline_favorite_border_24_black)
                        binding.imgShare.setImageResource(R.drawable.ic_baseline_share_24_black)
                        binding.txTitle.visibility= View.VISIBLE
                    }else if(verticalOffset>-1265){
                        binding.toolbar.setBackgroundDrawable(ContextCompat.getDrawable(this@ProductActivity,R.color.statusTrans))
                        binding.arrow.setImageResource(R.drawable.ic_baseline_arrow_back_24_white)
                        binding.productInfoBtnCart.setImageResource(R.drawable.ic_baseline_favorite_border_24_white)
                        binding.imgShare.setImageResource(R.drawable.ic_baseline_share_24_white)
                        binding.txTitle.visibility= View.INVISIBLE
                    }
                }
            }
        })

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("햄버거"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("세트"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("디저트"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("음료"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("팩"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("치킨"))

        //stickscrollview
        binding.nestedScroll.run {
            header = binding.tabLayout
            stickListener = {_ ->
                Log.d("LOGGER_TAG","stickListener")
            }
            freeListener={_ ->
                Log.d("LOGGER_TAG","freeListener")
            }
        }
    }
}