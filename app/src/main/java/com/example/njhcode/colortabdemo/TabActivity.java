package com.example.njhcode.colortabdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    ColorClipTabLayout tablayout;
    ViewPager viewPager;
    List<TestFragment> list = new ArrayList<>();
    List<String> list2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tablayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view_pager);

        for (int i = 0; i < 10; i++) {
            list.add(TestFragment.newInstance(i));
            list2.add("我是火车王" + String.valueOf(i));
        }
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        tablayout.setupWithViewPager(viewPager);
    }

    class MyFragmentAdapter extends FragmentPagerAdapter {

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list2.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
