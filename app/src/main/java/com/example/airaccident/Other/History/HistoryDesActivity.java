package com.example.airaccident.Other.History;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.airaccident.Other.History.hisbean.HistoryBean;
import com.example.airaccident.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryDesActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView emptyTv;
    private ListView historydesLv;
    private ImageView backIv;
    List<HistoryBean.ResultBean>mDatas;
    private HistoryAdapter adapter;
    HistoryBean historyBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_des);
        emptyTv=(TextView)findViewById(R.id.history_tv);
        historydesLv = (ListView) findViewById(R.id.history_des_lv);
        backIv = (ImageView) findViewById(R.id.history_iv_back);
        backIv.setOnClickListener(this);
        mDatas=new ArrayList<>();
        adapter = new HistoryAdapter(this, mDatas);
        historydesLv.setAdapter(adapter);
        try {
            //获取上一级的数据
            Intent intent =getIntent();
            Bundle bundle=intent.getExtras();
            historyBean=(HistoryBean)bundle.getSerializable("history");
            List<HistoryBean.ResultBean>list=historyBean.getResult();
            mDatas.addAll(list);
            adapter.notifyDataSetChanged();
        }catch (Exception e){
            emptyTv.setVisibility(View.VISIBLE);
        }
        historydesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(HistoryDesActivity.this,HistoryDescActivity.class);
                HistoryBean.ResultBean resultBean=mDatas.get(position);
                String bean_id = resultBean.get_id();
                intent.putExtra("hisId",bean_id);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.history_iv_back:
                finish();
                break;
        }
    }
}
