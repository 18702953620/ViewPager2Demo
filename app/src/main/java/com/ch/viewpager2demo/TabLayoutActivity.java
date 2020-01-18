package com.ch.viewpager2demo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.ch.viewpager2demo.adapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ch
 * @date 2020/1/11 10:53
 * @desc TabLayout
 */
public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 vpTablayout;
    private List<String> titles;
    private TabLayoutMediator tabLayoutMediator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        tabLayout = findViewById(R.id.tabLayout);
        vpTablayout = findViewById(R.id.vpTablayout);
        titles = new ArrayList<>();
        titles.add("title0");
        titles.add("title1");
        titles.add("title2");

        TabLayout.Tab tab1 = tabLayout.newTab();
        tab1.setCustomView(R.layout.tab_item);
        TextView tvTitle = tab1.getCustomView().findViewById(R.id.tvTitle);
        tvTitle.setText("带图标");
        tabLayout.addTab(tab1);
        TabLayout.Tab tab2 = tabLayout.newTab().setText("自定义标题1");
        tabLayout.addTab(tab2);
        TabLayout.Tab tab3 = tabLayout.newTab().setText("自定义标题2");
        tabLayout.addTab(tab3);


        TabAdapter tabAdapter = new TabAdapter(this, titles);
        vpTablayout.setAdapter(tabAdapter);

        tabLayoutMediator = new TabLayoutMediator(tabLayout, vpTablayout, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
            }
        });
        tabLayoutMediator.attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpTablayout.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vpTablayout.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }

    @Override
    protected void onDestroy() {
        if (tabLayoutMediator != null) {
            tabLayoutMediator.detach();
        }
        super.onDestroy();
    }
}
