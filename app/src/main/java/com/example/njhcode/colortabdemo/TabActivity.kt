package com.example.njhcode.colortabdemo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import java.util.ArrayList

class TabActivity : AppCompatActivity() {

    lateinit var tablayout: ColorClipTabLayout
    lateinit var viewPager: ViewPager
    internal var list: MutableList<TestFragment> = ArrayList()
    internal var list2: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        tablayout = findViewById(R.id.tab)
        viewPager = findViewById(R.id.view_pager)

        for (i in 0..9) {
            list.add(TestFragment.newInstance(i))
            list2.add("我是火车王" + i.toString())
        }
        viewPager.adapter = MyFragmentAdapter(supportFragmentManager)
        tablayout.setupWithViewPager(viewPager)
    }

    internal inner class MyFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return list[position]
        }

        override fun getPageTitle(position: Int): CharSequence {
            return list2[position]
        }

        override fun getCount(): Int {
            return list.size
        }
    }
}
