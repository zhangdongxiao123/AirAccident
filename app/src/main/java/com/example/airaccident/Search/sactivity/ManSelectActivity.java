package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.airaccident.R;

public class ManSelectActivity extends AppCompatActivity implements View.OnClickListener{
    Button zengjia,genggai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_select);
        //1.绑定控件
        zengjia=findViewById(R.id.manSelect_zengjia);
        genggai=findViewById(R.id.manSelect_genggai);
        //2.设置点击事件
        zengjia.setOnClickListener(this);
        genggai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.manSelect_zengjia:
                Intent intent1=new Intent(this, ManAddActivity.class);
                startActivity(intent1);
                break;
            case R.id.manSelect_genggai:
                Intent intent2=new Intent(this, ManChooseActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
