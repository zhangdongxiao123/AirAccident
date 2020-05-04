package com.example.airaccident.Activity;


import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import com.example.airaccident.Fragment.MainFragment;
import com.example.airaccident.Fragment.MineFragment;
import com.example.airaccident.Fragment.MoreFragment;
import com.example.airaccident.Fragment.SearchFragment;
import com.example.airaccident.R;


public class MainActivity extends FragmentActivity{
    //四个fragment
    private Class[] fragments = new Class[]{MainFragment.class,SearchFragment.class, MineFragment.class, MoreFragment.class};
    //底部图片
    private int[] imgSelectors = new int[] {
            R.drawable.ic_home_tab_index_selector,
            R.drawable.ic_home_tab_search_selector,
            R.drawable.ic_home_tab_my_selector,
            R.drawable.ic_home_tab_more_selector
    };
    //底部文字
    private  String[] tabTitles = new String[]{"首页","查询","我的","更多"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建一个fragment对象
        FragmentTabHost tabHost=(FragmentTabHost) findViewById(R.id.tabHost);
        //启动
        tabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);
        //把这四个碎片塞进活动中
        for (int i = 0; i < fragments.length; i++){
            //获取
            View inflate=getLayoutInflater().inflate(R.layout.tab_item,null);
            ImageView tab_iv=inflate.findViewById(R.id.iv);
            TextView tav_tv=inflate.findViewById(R.id.tv);
            tab_iv.setImageResource(imgSelectors[i]);
            tav_tv.setText(tabTitles[i]);
            tabHost.addTab(tabHost.newTabSpec(""+i).setIndicator("tab1").setIndicator(inflate),fragments[i],null);
        }

    }
}