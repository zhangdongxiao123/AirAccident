package com.example.airaccident.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.airaccident.R;
import com.example.airaccident.Search.sactivity.ReasonSecondActivity;
import com.example.airaccident.bean.ReasonBean;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;



public class NewsReasonAdapter extends  RecyclerView.Adapter<NewsReasonAdapter.MyViewHolder> {

    private Context context;
    private MyViewHolder myViewHolder;
    List<ReasonBean.DataBean> list;

    public NewsReasonAdapter(Context context, List<ReasonBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_reason,parent,false);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.item_single_id.setText("原因id："+list.get(position).getReaid());
        holder.item_single_name.setText("原因名称："+list.get(position).getReaname());
        holder.item_reason_detail.setText("原因详情："+list.get(position).getReahow());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReasonSecondActivity.class);
                intent.putExtra("airwhy",list.get(position).getReaname()+"");
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
        TextView item_reason_detail;


        public MyViewHolder(final View itemView) {
            super(itemView);
            item_single_id = itemView.findViewById(R.id.item_reason_id);
            item_single_name = itemView.findViewById(R.id.item_reason_name);
            item_reason_detail = itemView.findViewById(R.id.item_reason_detail);

        }
    }


}
