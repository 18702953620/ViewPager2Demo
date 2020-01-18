package com.ch.viewpager2demo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ch.viewpager2demo.fragment.DemoFragment;

import java.util.List;

/**
 * @author ch
 * @date 2020/1/10 16:34
 * @desc
 */
public class BaseFragmentStateAdapter extends FragmentStateAdapter {

    private List<DemoFragment> fragments;

    public BaseFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity, List<DemoFragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    public BaseFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
