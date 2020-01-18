package com.ch.viewpager2demo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ch.viewpager2demo.fragment.DemoFragment;

import java.util.List;

/**
 * @author ch
 * @date 2020/1/13 18:10
 * @desc
 */
public class TabAdapter extends FragmentStateAdapter {
    private List<String> titles;

    public TabAdapter(@NonNull FragmentActivity fragmentActivity, List<String> titles) {
        super(fragmentActivity);
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new DemoFragment(titles.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}
