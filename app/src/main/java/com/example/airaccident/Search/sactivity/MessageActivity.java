package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.airaccident.R;
import com.example.airaccident.bean.DetailBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import static com.example.airaccident.app.Url.airdetailDetail;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {
    TextView airid,airname,airtype,airwhen,airwhere,airwhy,airhow;
    ImageView airimg,fanhui,fenxiang;
    String id = "";
    DetailBean detailBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        //1.绑定控件
        airid=(TextView) findViewById(R.id.message_airid);
        airname=(TextView)findViewById(R.id.message_airname);
        airtype=(TextView)findViewById(R.id.message_airtype);
        airwhen=(TextView)findViewById(R.id.message_airwhen);
        airwhere=(TextView)findViewById(R.id.message_airwhere);
        airwhy=(TextView)findViewById(R.id.message_airwhy);
        airhow=(TextView)findViewById(R.id.message_airhow);
        airimg=(ImageView) findViewById(R.id.message_airimg);
        fanhui=(ImageView) findViewById(R.id.message_fanhui);
        fenxiang=(ImageView) findViewById(R.id.message_fenxiang);
        //设置点击事件
        fanhui.setOnClickListener(this);
        fenxiang.setOnClickListener(this);
        //获取传过来的id
        id = getIntent().getStringExtra("id");

        OkHttpUtils.post()
                .url(airdetailDetail)
                .addParams("airid",id)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            Log.e("请求的",response);
                            detailBean = JSON.parseObject(response, DetailBean.class);
                            airid.setText("事故id:"+detailBean.getData().getAirid());
                            airname.setText("事故名称:"+detailBean.getData().getAirname());
                            airtype.setText("事故类型:"+detailBean.getData().getAirtype());

                            airwhen.setText("事故时间:"+detailBean.getData().getAirwhen());
                            airwhere.setText("事故地点:"+detailBean.getData().getAirwhere());
                            airwhy.setText("事故原因:"+detailBean.getData().getAirwhy());
                            airhow.setText("事故详情："+detailBean.getData().getAirhow());

                            Glide.with(MessageActivity.this)
                                    .load(detailBean.getData().getAirimg())
                                    .into(airimg);

                        }catch (Exception e)
                        {

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_fanhui:
                break;
            case R.id.message_fenxiang:
                break;
        }
    }
}
