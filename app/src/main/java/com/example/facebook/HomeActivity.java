package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.facebook.Adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private TabLayout mTablayout;
    private ViewPager mviewPager;
    private ArrayList <Integer> iconlist;
    private Context context;
    private TextView btn_Search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTablayout = findViewById(R.id.tab_layout);
        mviewPager = findViewById(R.id.view_pager);
        btn_Search = findViewById(R.id.btn_Search);



        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mviewPager.setAdapter(viewPagerAdapter);
        mTablayout.setupWithViewPager(mviewPager);
        iconlist = new ArrayList<>();
        iconlist.add(R.drawable.ic_baseline_home_24);
        iconlist.add(R.drawable.ic_baseline_ondemand_video_24);
        iconlist.add(R.drawable.ic_baseline_home_work_24);
        iconlist.add(R.drawable.ic_baseline_notifications_24);
        iconlist.add(R.drawable.ic_baseline_menu_24);
        for(int i=0;i<mTablayout.getTabCount();i++) {
                mTablayout.getTabAt(i).setIcon(iconlist.get(i));
                mTablayout.getTabAt(i).setTabLabelVisibility(TabLayout.TAB_LABEL_VISIBILITY_UNLABELED);
        }
        mTablayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.tabSelectedIconColor);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.tabUnselectedIconColor);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        btn_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

    }
}