package com.example.airaccident.Other.AccInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.airaccident.Other.AccInfo.accbean.AccBean;
import com.example.airaccident.R;

import java.util.List;

//1.继承BaseAdapter
//2.重写四个方法
public class AccAdapter extends BaseAdapter {
    //3.传值
    Context context;
    //4.ListView中想显示什么内容
    List<AccBean.ResultBean> mDatas;
    //5.生成构造方法
    public AccAdapter(Context context, List<AccBean.ResultBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }
    //6.修改一下三个方法
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
        //10.getView,先对ViewHolder进行声明
        ViewHolder1 holder = null;
        //11.判断convertView是否为空
        if (convertView == null) {
            //12.如果为空，就去创建它,（即找到该布局）
            convertView= LayoutInflater.from(context).inflate(R.layout.acc_list_list,null);
            //13.找到ViewHolder里面的控件，就去创建它（绑定布局中的控件）
            holder=new ViewHolder1(convertView);
            //14.设置convertView的id
            convertView.setTag(holder);
        }else {
            //15.找到这个Tag，设置给holder
            holder=(ViewHolder1) convertView.getTag();
        }
        //17.得到指定位置的数据源
        AccBean.ResultBean resultBean=mDatas.get(position);
        //18.设置显示的数据
        holder.id.setText(resultBean.getAirid());
        holder.name.setText(resultBean.getAirname());
        holder.type.setText(resultBean.getAirtype());
        holder.when.setText(resultBean.getAirwhen());
        holder.where.setText(resultBean.getAirwhere());
        holder.why.setText(resultBean.getAirwhy());
        //16.返回convertView
        return convertView;
    }
    //7.在getView当中为了减少findViewById的次数，写一个ViewHolder
    class ViewHolder1{
        TextView id,name,type,when,where,why;
        //8.将findViewById的次数写到构造函数当中
        public ViewHolder1(View itemView){
            //9.对这些内容进行查找
            id=itemView.findViewById(R.id.acc_list_list_id);
            name=itemView.findViewById(R.id.acc_list_list_mingcheng);
            type=itemView.findViewById(R.id.acc_list_list_leixing);
            when=itemView.findViewById(R.id.acc_list_list_shijian);
            where=itemView.findViewById(R.id.acc_list_list_didian);
            why=itemView.findViewById(R.id.acc_list_list_yuanyin);
        }
    }
}
