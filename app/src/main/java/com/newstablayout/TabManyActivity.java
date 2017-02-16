package com.newstablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by zq on 2017/1/12.
 */

public class TabManyActivity extends AppCompatActivity {
    private TabLayout tabLayout = null;
    private ViewPager vp_pager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tab_layout);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        vp_pager = (ViewPager) findViewById(R.id.tab_viewpager);
        initView();
    }
    private void initView() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        vp_pager.setAdapter(new MorePagerAdapter());
        tabLayout.setupWithViewPager(vp_pager);
    }
    final class MorePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(TabManyActivity.this);
            tv.setText("布局" + position);
            tv.setTextSize(30.0f);
            tv.setGravity(Gravity.CENTER);
            (container).addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            (container).removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "选项" + position;
        }
    }
}