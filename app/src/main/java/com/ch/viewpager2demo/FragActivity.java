package com.ch.viewpager2demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.PopupWindow;

import com.ch.viewpager2demo.adapter.BaseFragmentStateAdapter;
import com.ch.viewpager2demo.adapter.TabAdapter;
import com.ch.viewpager2demo.fragment.DemoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ch
 * @date 2020/1/11 10:53
 * @desc fragment
 */
public class FragActivity extends AppCompatActivity {

    private List<DemoFragment> fragmentList;
    private ViewPager2 vpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        vpFragment = findViewById(R.id.vpFragment);
        vpFragment.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        fragmentList = new ArrayList<>();
        fragmentList.add(new DemoFragment());
        fragmentList.add(new DemoFragment());
        fragmentList.add(new DemoFragment());
        fragmentList.add(new DemoFragment());
        fragmentList.add(new DemoFragment());
        fragmentList.add(new DemoFragment());
        fragmentList.add(new DemoFragment());
        fragmentList.add(new DemoFragment());

        BaseFragmentStateAdapter stateAdapter = new BaseFragmentStateAdapter(this, fragmentList);
        vpFragment.setAdapter(stateAdapter);


//        List<String> titles = new ArrayList<>();
//        titles.add("title0");
//        titles.add("title1");
//        titles.add("title2");
//        TabAdapter tabAdapter = new TabAdapter(this, titles);
//        vpFragment.setAdapter(tabAdapter);
    }
}
