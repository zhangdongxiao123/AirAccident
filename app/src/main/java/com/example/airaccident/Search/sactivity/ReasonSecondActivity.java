package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.airaccident.Adapter.SingleAdapter;
import com.example.airaccident.R;
import com.example.airaccident.bean.SingleBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import static com.example.airaccident.app.Url.airwhyselect;

public class ReasonSecondActivity extends AppCompatActivity {

    RecyclerView recy;
    String airwhy ="";
    SingleBean singleBean;
    //ReasonAdapter singleAdapter;
    SingleAdapter singleAdapter;
    List<SingleBean.DataBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason_second);

        recy = findViewById(R.id.recy);

        list = new ArrayList<>();
        singleAdapter = new SingleAdapter(this,list);
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setAdapter(singleAdapter);

        airwhy= getIntent().getStringExtra("airwhy");

        Toast.makeText(this, airwhy+"", Toast.LENGTH_SHORT).show();

        OkHttpUtils.get()
                .url(airwhyselect+"?airwhy="+airwhy)
                //.addParams("",)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }
                    @Override
                    public void onResponse(String response, int id) {
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
                    }
                });
    }
}
