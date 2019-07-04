package com.tw.music;

import android.view.View;

import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class MyPageTransformer  implements ViewPager2.PageTransformer {

    private static final float ROT_MAX = 20.0f;
    private float mRot;

    /**
     * @param view     滑动中的那个view
     * @param position
     */
    public void transformPage(View view, float position) {


        //界面不可见
        if (position < -1) {
            ViewCompat.setRotation(view, 0);

        }
        //界面可见
        else if (position <= 1) {
            mRot = (ROT_MAX * position);
            ViewCompat.setPivotX(view, view.getMeasuredWidth() * 0.5f);
            ViewCompat.setPivotY(view, view.getMeasuredHeight());
            ViewCompat.setRotation(view, mRot);

        }
        //界面不可见
        else {
            ViewCompat.setRotation(view, 0);
        }
    }
}