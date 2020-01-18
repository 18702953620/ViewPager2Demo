package com.ch.viewpager2demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ch.viewpager2demo.adapter.BaseAdapter;

import java.util.Random;

/**
 * @author ch
 * @date 2020/1/11 10:53
 * @desc 基本使用
 */
public class BaseActivity extends AppCompatActivity {

    private ViewPager2 vpBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        vpBase = findViewById(R.id.vpBase);

        BaseAdapter baseAdapter = new BaseAdapter();
        //方向
        vpBase.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        vpBase.setAdapter(baseAdapter);

        //滑动监听
        vpBase.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(BaseActivity.this, "select " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        //禁止滑动
        vpBase.setUserInputEnabled(false);
        //预加载
        vpBase.setOffscreenPageLimit(1);
    }



}
