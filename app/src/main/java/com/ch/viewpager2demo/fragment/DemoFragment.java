package com.ch.viewpager2demo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ch.viewpager2demo.R;

import java.util.Random;

/**
 * @author ch
 * @date 2020/1/11 11:08
 * @desc
 */
public class DemoFragment extends Fragment {


    private TextView tvDemo;
    private String title;

    public DemoFragment(String title) {
        this.title = title;
    }

    public DemoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_demo, container, false);
        tvDemo = view.findViewById(R.id.tvDemo);
        int color = Color.parseColor(randomHexStr(6));
        tvDemo.setBackgroundColor(color);
        tvDemo.setText(TextUtils.isEmpty(title) ? "" + color : title);
        return view;
    }

    /**
     * 获取指定长度的16进制字符串.
     */
    public static String randomHexStr(int len) {
        try {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < len; i++) {
                //随机生成0-15的数值并转换成16进制
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            return "#" + result.toString().toUpperCase();
        } catch (Exception e) {
            System.out.println("获取16进制字符串异常，返回默认...");
            return "#00CCCC";
        }
    }
}
