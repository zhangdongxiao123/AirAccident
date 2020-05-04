package com.example.airaccident.Other.PicInfo.AirGrid;

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

public class AirGridAdapter extends BaseAdapter {
    Context context;
    List<AirBean> mDatas;

    public AirGridAdapter(Context context, List<AirBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //声明ViewHolder
        ViewHolder holder=null;
        //判断是否有复用的view，如果没有就创建
        if(view == null){
            view= LayoutInflater.from(context).inflate(R.layout.item_airgrid,null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder=(ViewHolder) view.getTag();
        }
        //获取指定位置的数据
        AirBean airBean=mDatas.get(i);
        holder.iv.setImageResource(airBean.getPicId());
        holder.tv.setText(airBean.getTitle());
        return view;
    }
    //界面上需要显示什么
    class ViewHolder{
        ImageView iv;
        TextView tv;
        public ViewHolder(View view){
            iv=view.findViewById(R.id.item_grid_iv);
            tv=view.findViewById(R.id.item_grid_tv);
        }
    }
}
