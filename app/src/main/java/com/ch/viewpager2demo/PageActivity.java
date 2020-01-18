package com.ch.viewpager2demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.ch.viewpager2demo.adapter.BaseAdapter;
import com.ch.viewpager2demo.utils.DensityUtils;

/**
 * @author ch
 * @date 2020/1/11 10:53
 * @desc page
 */
public class PageActivity extends AppCompatActivity {
    private ViewPager2 vpBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        vpBase = findViewById(R.id.vpBase);
        BaseAdapter baseAdapter = new BaseAdapter();
//        vpBase.setPageTransformer(new MarginPageTransformer(DensityUtils.dp2px(this, 20)));
        CompositePageTransformer pageTransformer = new CompositePageTransformer();
        pageTransformer.addTransformer(new MarginPageTransformer(DensityUtils.dp2px(this, 20)));
        pageTransformer.addTransformer(new ScalePageTransformer());
        vpBase.setPageTransformer(pageTransformer);
        vpBase.setAdapter(baseAdapter);


    }


    class ScalePageTransformer implements ViewPager2.PageTransformer {
        private static final float DEFAULT_MIN_SCALE = 0.85f;
        private static final float DEFAULT_CENTER = 0.5f;
        private float mMinScale = DEFAULT_MIN_SCALE;

        @Override
        public void transformPage(@NonNull View view, float position) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setElevation(-Math.abs(position));
            }

            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            view.setPivotY(pageHeight / 2);
            view.setPivotX(pageWidth / 2);
            if (position < -1) {
                view.setScaleX(mMinScale);
                view.setScaleY(mMinScale);
                view.setPivotX(pageWidth);
            } else if (position <= 1) {
                if (position < 0) {
                    float scaleFactor = (1 + position) * (1 - mMinScale) + mMinScale;
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                    view.setPivotX(pageWidth * (DEFAULT_CENTER + DEFAULT_CENTER * -position));
                } else {
                    float scaleFactor = (1 - position) * (1 - mMinScale) + mMinScale;
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                    view.setPivotX(pageWidth * ((1 - position) * DEFAULT_CENTER));
                }
            } else {
                view.setPivotX(0);
                view.setScaleX(mMinScale);
                view.setScaleY(mMinScale);
            }
        }
    }
}
