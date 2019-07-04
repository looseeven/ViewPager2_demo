package com.tw.music;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

public class Activity extends AppCompatActivity {

    public static ViewPager2 mViewPager;
    private ViewPagerFragmentStateAdapter mAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, Activity.class);
        context.startActivity(starter);
    }
    List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewpager2);
        mAdapter = new ViewPagerFragmentStateAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        mViewPager.setPageTransformer(new MyPageTransformer());
        fragments.add(new Fragment1(mViewPager));
        fragments.add(new Fragment2(mViewPager));
    }

    class ViewPagerFragmentStateAdapter extends FragmentStateAdapter {


        public ViewPagerFragmentStateAdapter(@NonNull FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
                return fragments.get(position);
        }

        /**页面个数*/
        @Override
        public int getItemCount() {
            return fragments.size();
        }
    }

    public static void setCurrentItem(int position){
        mViewPager.setCurrentItem(position);
    }

}
