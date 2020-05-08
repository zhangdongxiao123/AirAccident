package com.example.airaccident.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.airaccident.R;
import com.example.airaccident.Search.sactivity.ManChangeActivity;
import com.example.airaccident.bean.SingleBean;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;



public class ManChooseAdapter extends  RecyclerView.Adapter<ManChooseAdapter.MyViewHolder> {

    private Context context;
    private MyViewHolder myViewHolder;
    List<SingleBean.DataBean> list;

    public ManChooseAdapter(Context context, List<SingleBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_single,parent,false);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.item_single_id.setText("id:"+list.get(position).getAirid());
        holder.item_single_name.setText("标题："+list.get(position).getAirname());
        holder.item_single_type.setText("类型："+list.get(position).getAirtype());
        holder.item_single_when.setText("时间："+list.get(position).getAirwhen());
        holder.item_single_where.setText("地点："+list.get(position).getAirwhere());
        holder.item_single_why.setText("原因："+list.get(position).getAirwhy());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(context, ManChangeActivity.class);
                 intent.putExtra("id",list.get(position).getAirid()+"");
                 context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_single_id;
        TextView item_single_name;
        TextView item_single_type;
        TextView item_single_when;
        TextView item_single_where;
        TextView item_single_why;

        public MyViewHolder(final View itemView) {
            super(itemView);
            item_single_id = itemView.findViewById(R.id.item_single_id);
            item_single_name = itemView.findViewById(R.id.item_single_name);
            item_single_type = itemView.findViewById(R.id.item_single_type);
            item_single_when = itemView.findViewById(R.id.item_single_when);
            item_single_where = itemView.findViewById(R.id.item_single_where);
            item_single_why = itemView.findViewById(R.id.item_single_why);
        }
    }


}
