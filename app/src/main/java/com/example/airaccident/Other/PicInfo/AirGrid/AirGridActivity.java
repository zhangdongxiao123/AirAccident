package com.example.airaccident.Other.PicInfo.AirGrid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.airaccident.Other.PicInfo.AirDescActivity;
import com.example.airaccident.R;
import com.example.airaccident.Other.PicInfo.Bean.AirBean;
import com.example.airaccident.Other.PicInfo.Bean.AirUtils;

import java.util.List;

public class AirGridActivity extends AppCompatActivity {
    GridView gv;
    List<AirBean> mDatas;
    private AirGridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_grid);
        gv=findViewById(R.id.air_grid_gv);
        //获取数据源
        mDatas= AirUtils.getAllAirList();
        //创建适配器对象
        adapter=new AirGridAdapter(this,mDatas);
        //设置适配器
        gv.setAdapter(adapter);
        //设置GridView的单向点击监听功能
        setListener();
    }
    private void setListener() {
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AirBean airBean=mDatas.get(position);
                Intent intent=new Intent(AirGridActivity.this, AirDescActivity.class);
                intent.putExtra("air",airBean);
                startActivity(intent);
            }
        });
    }
}
