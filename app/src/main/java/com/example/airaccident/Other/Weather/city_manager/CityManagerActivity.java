package com.example.airaccident.Other.Weather.city_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.airaccident.R;
import com.example.airaccident.Other.Weather.wdb.DBManager;
import com.example.airaccident.Other.Weather.wdb.DatabaseBean;

import java.util.ArrayList;
import java.util.List;

public class CityManagerActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView addIv,backIv,deleteIv;
    ListView cityLv;
    List<DatabaseBean> mDatas;//作为列表的数据源
    private CityManagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        addIv=findViewById(R.id.city_iv_add);
        backIv=findViewById(R.id.city_iv_back);
        deleteIv=findViewById(R.id.city_iv_delete);
        cityLv=findViewById(R.id.city_lv);
        mDatas=new ArrayList<>();
        //添加点击事件
        addIv.setOnClickListener(this);
        deleteIv.setOnClickListener(this);
        backIv.setOnClickListener(this);
        //设置适配器
        adapter = new CityManagerAdapter(this, mDatas);
        cityLv.setAdapter(adapter);

    }
    //获取数据库当中真实数据源，添加到原有数据源当中，提示适配器更新
    @Override
    protected void onResume() {
        super.onResume();
        List<DatabaseBean>list=DBManager.queryAllInfo();
        mDatas.clear();
        mDatas.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.city_iv_add:
                int cityCount=DBManager.getCityCount();
                if(cityCount<5){
                    Intent intent=new Intent(this, SearchCityActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(this,"存储数量已达上限，请删除后再增加",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.city_iv_back:
                finish();
                break;
            case R.id.city_iv_delete:
                Intent intent1=new Intent(this, DeleteCityActivity.class);
                startActivity(intent1);
        }
    }
}
