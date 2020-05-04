package com.example.airaccident.Other.Weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class CityFragmentPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList;

    public CityFragmentPagerAdapter(@NonNull FragmentManager fm,List<Fragment>fragmentList1) {
        super(fm);
        this.fragmentList=fragmentList1;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    int childCount=0;//表示ViewPager包含的页数
    //当ViewPager的页数发生变化时，必须要重写两个函数
    //获取某个位置的item


    @Override
    public void notifyDataSetChanged() {
        //获取此时子页面的数量
        this.childCount=getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (childCount>0) {
            childCount--;
            return POSITION_NONE;//返回位置的标识
        }
        return super.getItemPosition(object);
    }
}
