package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.airaccident.Adapter.NewsReasonAdapter;
import com.example.airaccident.R;
import com.example.airaccident.bean.ReasonBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import static com.example.airaccident.app.Url.reasonall;

public class NewsReasonActivity extends AppCompatActivity {

    RecyclerView recy;
    NewsReasonAdapter newsReasonAdapter;
    ReasonBean reasonBean;
    List<ReasonBean.DataBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_reason);
        recy = findViewById(R.id.recy);

        list = new ArrayList<>();
        recy.setLayoutManager(new LinearLayoutManager(this));
        newsReasonAdapter = new NewsReasonAdapter(this,list);
        recy.setAdapter(newsReasonAdapter);

        OkHttpUtils.get()
                .url(reasonall)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            Log.e("请求的",response);
                            reasonBean = JSON.parseObject(response, ReasonBean.class);
                            list.addAll(reasonBean.getData());
                            newsReasonAdapter.notifyDataSetChanged();

                        }catch (Exception e)
                        {

                        }
                    }
                });
    }
}
