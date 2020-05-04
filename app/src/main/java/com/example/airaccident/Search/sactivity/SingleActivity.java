package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.airaccident.Adapter.SingleAdapter;
import com.example.airaccident.R;
import com.example.airaccident.bean.SingleBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import static com.example.airaccident.app.Url.singleSelect;

public class SingleActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView shuaxin,sousuo;
    EditText shuru;
    RecyclerView liebiao;
    SingleBean singleBean;
    SingleAdapter singleAdapter;
    List<SingleBean.DataBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        //1.找到控件
        list = new ArrayList<>();
        shuaxin=findViewById(R.id.single_shuaxin);//刷新
        sousuo=findViewById(R.id.single_sousuo);//搜索
        shuru=findViewById(R.id.single_shuru);//输入
        liebiao=findViewById(R.id.single_liebiao);//列表
        //给列表设置适配器
        singleAdapter = new SingleAdapter(this,list);
        liebiao.setLayoutManager(new LinearLayoutManager(this));
        liebiao.setAdapter(singleAdapter);
        //2.设置点击事件
        shuaxin.setOnClickListener(this);
        sousuo.setOnClickListener(this);
        //传入关键字
        getok("");


    }

    private void getok(String keyword) {
        OkHttpUtils.get()
                .url(singleSelect+"?keyword="+keyword)
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.single_shuaxin:
                shuru.setText("");
                getok("");

//                list.clear();
//                singleAdapter.notifyDataSetChanged();
                break;
            case R.id.single_sousuo:
                String keyword = shuru.getText().toString();
                if (keyword.equals(""))
                {
                    Toast.makeText(this, "请输入关键词", Toast.LENGTH_SHORT).show();
                    return;
                }
                //搜索请求事件
                getok(keyword);
                break;
        }
    }
}
