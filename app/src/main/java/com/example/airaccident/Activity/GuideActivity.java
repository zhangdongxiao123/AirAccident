package com.example.airaccident.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.airaccident.R;

import java.util.ArrayList;
import java.util.List;


public class GuideActivity extends AppCompatActivity {
    //获取图片的资源
    int[] imgRes = new int[]{R.drawable.guide1, R.drawable.guide2, R.drawable.guide3};
    private List<View> mViewList = new ArrayList<>();


    private  ViewPager mVpGuide;
    private  Button mBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mVpGuide =(ViewPager)findViewById(R.id.viewPager);
        MyPagerAdapter adapter = new MyPagerAdapter();
        mVpGuide.setAdapter(adapter);
        mVpGuide.setOnPageChangeListener(new MyListener());
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();
            }
        });
    }
    //初始化数据
    private void initData(){
        for(int i = 0; i<imgRes.length;i++){
            View inflate= getLayoutInflater().inflate(R.layout.guide_item,null);
            ImageView ivGuide = (ImageView) inflate.findViewById(R.id.iv_guide);
            ivGuide.setBackgroundResource(imgRes[i]);
            mViewList.add(inflate);
        }
    }
    //引导界面的viewpager适配器
    class MyPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return imgRes.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;//官方推荐的一个写法
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view=mViewList.get(position);
            container.addView(view);
            return view;//每一次子页的显示界面
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(mViewList.get(position));
        }
    }

    class MyListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        //ViewPager滚动到第几张
        @Override
        public void onPageSelected(int position) {
            //假如ViewPager滚动到最后一张，显示button
            if(position == imgRes.length-1){
                mBtnStart.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(GuideActivity.this,R.anim.anim_guide_btn_start);
                mBtnStart.startAnimation(animation);
            }else {
                mBtnStart.setVisibility(View.GONE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}