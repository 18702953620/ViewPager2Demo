package com.ch.viewpager2demo.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ch.viewpager2demo.R;

import java.util.Random;

/**
 * @author ch
 * @date 2020/1/18 14:31
 * @desc
 */
public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fm_demo, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int color = Color.parseColor(randomHexStr(6));
        holder.tvDemo.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDemo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDemo = itemView.findViewById(R.id.tvDemo);
        }
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
