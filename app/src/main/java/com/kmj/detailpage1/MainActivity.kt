package com.kmj.detailpage1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_page1.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //뒤로가기 버튼
//        back_button.setOnClickListener {
//            //화면 위에 있는 뒤로가기 버튼 누르면 홈 화면으로 이동함
//        }


        // 탭 레이아웃 만든 부분
        tab_layout.addTab(tab_layout.newTab().setText("츄밥"))
        tab_layout.addTab(tab_layout.newTab().setText("comment"))

        //탭 하단 아이콘
        tab_layout.getTabAt(0)?.setIcon(R.drawable.foodicon2)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.comment)

        val pagerAdapter = PagerAdapter(supportFragmentManager, 2)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }
}

class PagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Detail_page1()
            }
            1 -> {
                return Temp_Page() //임시로 만들어놓은 페이지
            }

            else -> return Detail_page1()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}
