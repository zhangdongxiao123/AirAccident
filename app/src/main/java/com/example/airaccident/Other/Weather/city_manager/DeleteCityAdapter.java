package com.example.airaccident.Other.Weather.city_manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.airaccident.R;

import java.util.List;

public class DeleteCityAdapter extends BaseAdapter {
    Context context;
    List<String>mDatas;
    //要删除的城市记录
    List<String>deleteCitys;

    public DeleteCityAdapter(Context context, List<String> mDatas, List<String> deleteCitys) {
        this.context = context;
        this.mDatas = mDatas;
        this.deleteCitys = deleteCitys;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //声明ViewHolder
        ViewHolder holder=null;
        //判断有没有能够复用的convertiView
        if (convertView==null) {
            //通过布局管理器，将指定的布局进行生成
            convertView= LayoutInflater.from(context).inflate(R.layout.item_delete,null);
            //生成holder对象
            holder=new ViewHolder(convertView);
            //设置标记
            convertView.setTag(holder);
        }else {
            //获取holder对象
            holder=(ViewHolder) convertView.getTag();
        }
        //获取指定位置所对应的数据源，即city名称
        String city= mDatas.get(position);
        //设置到TextView上
        holder.tv.setText(city);
        //获取是为了删除操作
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在当前城市集合中删除这个城市
                mDatas.remove(city);
                //将删除的这个城市记录到deleteCitys当中
                deleteCitys.add(city);
                //删除指定位置的城市后，提示adapter更新
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
    class ViewHolder{
        TextView tv;
        ImageView iv;
        public ViewHolder(View itemView){
            tv=itemView.findViewById(R.id.item_delete_tv);
            iv=itemView.findViewById(R.id.item_delete_iv);
        }
    }
}
