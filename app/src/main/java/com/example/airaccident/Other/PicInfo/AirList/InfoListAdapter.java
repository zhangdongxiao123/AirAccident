package com.example.airaccident.Other.PicInfo.AirList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.airaccident.R;
import com.example.airaccident.Other.PicInfo.Bean.AirBean;

import java.util.List;

public class InfoListAdapter extends BaseAdapter {
    //将数据源和ListView所在的页面传入进来
    Context context;//context是activity的父类，可以把父类的引用引向子类的对象activity
    List<AirBean> mDatas;

    public InfoListAdapter(Context context, List<AirBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }
   //决定了ListView展示的行数
    @Override
    public int getCount() {
        return mDatas.size();
    }
   //返回指定位置对应的数据
    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }
   //返回指定位置所对应的id
    @Override
    public long getItemId(int i) {
        return i;
    }
    //
    @Override
    public View getView(int i, View converView, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(converView == null){
            //将布局转换成view对象的方法
            converView = LayoutInflater.from(context).inflate(R.layout.item_infolist_lv,null);
            holder = new ViewHolder(converView);
            converView.setTag(holder);
        }else{
            holder =(ViewHolder) converView.getTag();
        }
        //加载控件当中的显示
        //首先获取集合指定位置的数据
        AirBean airBean=mDatas.get(i);
        holder.titleTv.setText(airBean.getTitle());
        holder.iv.setImageResource(airBean.getPicId());
        return converView;
    }

    class ViewHolder{
        ImageView iv;
        TextView titleTv;
        public ViewHolder(View view){
            iv=view.findViewById(R.id.item_info_iv);
            titleTv=view.findViewById(R.id.item_info_tv_title);
        }

    }
}
