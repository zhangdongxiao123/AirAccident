package com.example.airaccident.Other.PicInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.airaccident.Other.PicInfo.Bean.AirBean;
import com.example.airaccident.R;

public class AirDescActivity extends AppCompatActivity {
    TextView titleTv,descTv;
    ImageView backIv,bigPicIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_desc);
        initView();
        //接收上一级页面传来的数据
        Intent intent=getIntent();
        AirBean airBean=(AirBean)intent.getSerializableExtra("air");
        //设置显示控件
        titleTv.setText(airBean.getTitle());
        descTv.setText(airBean.getDesc());
        bigPicIv.setImageResource(airBean.getPicId());
    }

    private void initView() {
        titleTv=findViewById(R.id.airdesc_tv_title11);
        descTv=findViewById(R.id.airdesc_tv_desc);
        backIv=findViewById(R.id.airdesc_iv_back);
        bigPicIv=findViewById(R.id.airdes_iv_bigpic);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //销毁当前的activity
                finish();

            }
        });
    }
}
