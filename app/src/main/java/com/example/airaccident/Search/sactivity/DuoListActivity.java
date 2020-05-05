package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.example.airaccident.Adapter.SingleAdapter;
import com.example.airaccident.R;
import com.example.airaccident.bean.SingleBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import static com.example.airaccident.app.Url.allselect;

public class DuoListActivity extends AppCompatActivity implements View.OnClickListener {
//    ImageView fanhui;
    RecyclerView liebiao;

    String airname = "";
    String airtype = "";
    String airwhen = "";
    String airwhere = "";
    String airwhy = "";

    SingleBean singleBean;
    SingleAdapter singleAdapter;
    List<SingleBean.DataBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duo_list);
        initview();
        initData();



    }



    private void initview() {
        Intent intent  = getIntent();
        airname = intent.getStringExtra("airname");
        airtype = intent.getStringExtra("airtype");
        airwhen = intent.getStringExtra("airwhen");
        airwhere = intent.getStringExtra("airwhere");
        airwhy = intent.getStringExtra("airwhy");
        //1.绑定控件
//        fanhui=findViewById(R.id.duolist_fanhui);
        liebiao=findViewById(R.id.duolist_liebiao);

        list = new ArrayList<>();
        singleAdapter = new SingleAdapter(this,list);
        liebiao.setLayoutManager(new LinearLayoutManager(this));
        liebiao.setAdapter(singleAdapter);
        //2.设置点击事件
//        fanhui.setOnClickListener(this);//返回
    }

    private void initData() {
        //搜索请求事件
        OkHttpUtils.get()
                .url(allselect)
                .addParams("airname",airname)
                .addParams("airtype",airtype)
                .addParams("airwhen",airwhen)
                .addParams("airwhere",airwhere)
                .addParams("airwhy",airwhy)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {

                            try {
                                Log.e("请求的",response);
                                singleBean  = JSON.parseObject(response, SingleBean.class);
                                if (singleBean.getData().size()!=0)
                                {
                                    list.clear();
                                    list.addAll(singleBean.getData());
                                    singleAdapter.notifyDataSetChanged();
                                }else {
                                    list.clear();
                                    singleAdapter.notifyDataSetChanged();
                                }

                            }catch (Exception e)
                            {

                            }


                        }catch (Exception e)
                        {

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.duolist_fanhui:
//                break;
//        }
    }
}
