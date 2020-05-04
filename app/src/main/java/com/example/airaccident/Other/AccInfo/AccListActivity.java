package com.example.airaccident.Other.AccInfo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.airaccident.Other.AccInfo.accbase.AccURL;
import com.example.airaccident.Other.AccInfo.accbase.BaseAccActivity;
import com.example.airaccident.Other.AccInfo.accbean.AccBean;
import com.example.airaccident.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

//2.设置点击事件
public class AccListActivity extends BaseAccActivity implements View.OnClickListener {
    ImageView shuaxin,sousuo;
    EditText  shuru;
    ListView liebiao;
    //3.定义List集合
    List<AccBean.ResultBean>mDatas;
    private AccAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_list);
        //1.先找到各种控件
        shuaxin=(ImageView) findViewById(R.id.acc_list_shuaxin);
        sousuo=(ImageView) findViewById(R.id.acc_list_sousuo);
        shuru=(EditText) findViewById(R.id.acc_list_shuru);
        liebiao=(ListView) findViewById(R.id.acc_list_liebiao);
        //2.设置点击事件
        shuaxin.setOnClickListener(this);
        //4.先写一个空的集合
        mDatas=new ArrayList<>();
        //5.新建一个适配器,并生成成员变量
        adapter = new AccAdapter(this, mDatas);
        //6.设置给liebiao
        liebiao.setAdapter(adapter);
        //7.获取url网址
        String accURL = AccURL.getAccURL();
        //8.加载数据,首先要继承BaseAccAcivity,才能够去调用父类的方法
        loadData1(accURL);
    }

    //9.一旦成功，就会在onSuccess中显示
    @Override
    public void onSuccess(String result) {
        //10.把原来的内容先清空
        mDatas.clear();
        //11.加载成功数据，去解析一下,拿到这个类的对象
        AccBean accBean = new Gson().fromJson(result, AccBean.class);
        List<AccBean.ResultBean> list=accBean.getResult();
        //12.向mDatas中加入数据
        for (int i=0;i<5;i++){
            mDatas.add(list.get(i));
        }
        //13.通知adapter更新
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.acc_list_shuaxin:
//                mDatas.clear();
//                List<AccBean.ResultBean>list=new ArrayList<>();
//                AccBean.ResultBean ceshi1=new AccBean.ResultBean();
//                ceshi1.setAirid("123");
//                ceshi1.setAirname("123");
//                ceshi1.setAirtype("123");
//                ceshi1.setAirwhen("123");
//                ceshi1.setAirwhere("123");
//                ceshi1.setAirwhy("123");
//                ceshi1.setAirhow("123");
//                list.add(ceshi1);
//                AccBean.ResultBean ceshi2=new AccBean.ResultBean();
//                ceshi2.setAirid("321");
//                ceshi2.setAirname("321");
//                ceshi2.setAirtype("321");
//                ceshi2.setAirwhen("321");
//                ceshi2.setAirwhere("321");
//                ceshi2.setAirwhy("321");
//                ceshi2.setAirhow("321");
//                list.add(ceshi2);
//                mDatas.add(list.get(0));
//                mDatas.add(list.get(1));
//                adapter.notifyDataSetChanged();
                break;
        }

    }
}
