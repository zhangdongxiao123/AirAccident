package com.example.airaccident.Other.Weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;

import com.example.airaccident.R;
import com.example.airaccident.Other.Weather.city_manager.CityManagerActivity;
import com.example.airaccident.Other.Weather.wdb.DBManager;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener{
    //底部左右两个按钮
    ImageView addCityIv,moreIv;
    //添加指示器小点点
    LinearLayout pointLayout;
    //视图
    ViewPager mainVp;
    //ViewPager的数据源
    List<Fragment> fragmentList;
    //表示选中的城市的集合
    List<String>cityList;
    //表示ViewPager的页数指示器显示集合
    List<ImageView>imgList;
    //适配器
    private CityFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        addCityIv=(ImageView)findViewById(R.id.weather_iv_add);
        moreIv=(ImageView)findViewById(R.id.weather_iv_more);
        pointLayout=(LinearLayout)findViewById(R.id.weather_layout_point);
        mainVp=(ViewPager)findViewById(R.id.main_vp);
        //添加点击事件
        addCityIv.setOnClickListener(this);
        moreIv.setOnClickListener(this);
        //初始化集合
        fragmentList=new ArrayList<>();
        cityList= DBManager.queryAllCityName();//获取数据库包含的城市信息列表
        imgList=new ArrayList<>();

        if(cityList.size()==0){
            cityList.add("北京");
            cityList.add("上海");
            cityList.add("石家庄");
        }
        //因为可能搜索界面点击跳转到此界面会传值，所以在此处获取一下
        Intent intent=getIntent();
        String city=intent.getStringExtra("city");
        if (!cityList.contains(city)&&!TextUtils.isEmpty(city)) {
            cityList.add(city);
        }

        //初始化ViewPager页面的方法
        initPager();
        //对页面进行操作
        adapter=new CityFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        //设置给ViewPager
        mainVp.setAdapter(adapter);
        //创建小圆点指示器
        intPoint();
        //设置最后一个城市信息
        mainVp.setCurrentItem(fragmentList.size()-1);
        //设置ViewPager页面的方法
        setPagerListener();
    }

    private void setPagerListener() {
        //设置监听事件
        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < imgList.size(); i++) {
                    imgList.get(i).setImageResource(R.mipmap.a1);
                }
                imgList.get(position).setImageResource(R.mipmap.a2);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void intPoint() {
        //创建小圆点的方法
        for (int i = 0; i <fragmentList.size() ; i++) {
            ImageView pIv=new ImageView(this);
            pIv.setImageResource(R.mipmap.a1);
            pIv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            LinearLayout.LayoutParams lp= (LinearLayout.LayoutParams) pIv.getLayoutParams();
            //设置外边距
            lp.setMargins(0,0,20,0);
            //将这个ImageView添加到imageList当中
            imgList.add(pIv);
            pointLayout.addView(pIv);
        }
        imgList.get(imgList.size()-1).setImageResource(R.mipmap.a2);
    }

    private void initPager() {
        //创建Fragment对象，添加到ViewPager数据源当中
        for(int i=0;i<cityList.size();i++){
            CityWeatherFragment cwFrag=new CityWeatherFragment();
            Bundle bundle=new Bundle();
            bundle.putString("city",cityList.get(i));
            cwFrag.setArguments(bundle);
            fragmentList.add(cwFrag);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
           case R.id.weather_iv_add:
               intent.setClass(WeatherActivity.this, CityManagerActivity.class);
               break;
           case R.id.weather_iv_more:
               intent.setClass(WeatherActivity.this, WmoreActivity.class);
               break;
       }
        startActivity(intent);
    }

    //页面重新加载时会调用的函数，这个是在页面获取焦点之前进行调用，此处完成ViewPager页数的更新
    @Override
    protected void onRestart() {
        super.onRestart();
        //获取数据库当中还剩下的城市集合
        List<String> cityList1 = DBManager.queryAllCityName();
        //如果全部删除，添加北京
        if (cityList1.size()==0) {
            cityList1.add("北京");
        }
        cityList.clear();//重新加载之前，要清空原来的数据源
        cityList.addAll(cityList1);
        //剩下的城市也要创建对应的fragment页面
        fragmentList.clear();
        initPager();
        adapter.notifyDataSetChanged();
        //页面数量发生改变，指示器的数量也会发生变化，重新设置指示器
        imgList.clear();
        pointLayout.removeAllViews();//将布局当中所有元素全部移除
        intPoint();
        //显示在最后一个页面上
        mainVp.setCurrentItem(fragmentList.size()-1);
    }
}
