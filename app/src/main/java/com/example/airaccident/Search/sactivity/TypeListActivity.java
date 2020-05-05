package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.airaccident.R;

public class TypeListActivity extends AppCompatActivity implements View.OnClickListener{
//    ImageView fanhui;
    ListView liebiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_list);
        //1.绑定控件
//        fanhui=findViewById(R.id.typelist_fanhui);
        liebiao=findViewById(R.id.typelist_liebiao);
        //2.设置点击事件
//        fanhui.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.typelist_fanhui:
//                break;
//        }
    }
}
