package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.airaccident.Adapter.TypeAdapter;
import com.example.airaccident.R;
import com.example.airaccident.bean.SingleBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import static com.example.airaccident.app.Url.airtypeselect;

public class TypeActivity extends AppCompatActivity {
    RecyclerView liebiao;
    TypeAdapter typeAdapter;
    List<SingleBean.DataBean> list;
    String airtype = "";
    SingleBean singleBean;
    TextView tv_1,tv_2,tv_3,tv_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        //1.绑定控件
        liebiao=findViewById(R.id.type_liebiao);
        tv_1=findViewById(R.id.tv_1);
        tv_2=findViewById(R.id.tv_2);
        tv_3=findViewById(R.id.tv_3);
        tv_4=findViewById(R.id.tv_4);

        list = new ArrayList<>();
        typeAdapter = new TypeAdapter(this,list);
        liebiao.setLayoutManager(new LinearLayoutManager(this));
        liebiao.setAdapter(typeAdapter);

        tv_1.setOnClickListener(v->{
            airtype = "隐患";
            getokhttp();
        });
        tv_2.setOnClickListener(v->{
            airtype = "不安全事件";
            getokhttp();
        });
        tv_3.setOnClickListener(v->{
            airtype = "一般事故";
            getokhttp();
        });
        tv_4.setOnClickListener(v->{
            airtype = "重大事故";
            getokhttp();
        });




    }

    private void getokhttp() {
        OkHttpUtils.get()
                .url(airtypeselect+"?airtype="+airtype)
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
                                typeAdapter.notifyDataSetChanged();
                            }else {
                                list.clear();
                                typeAdapter.notifyDataSetChanged();
                            }

                        }catch (Exception e)
                        {

                        }
                    }
                });
    }
}
