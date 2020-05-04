package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.airaccident.R;

public class MultipleActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,type,when,where,why;
    Button duocha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);
        //1.绑定控件
        name=findViewById(R.id.multiple_name);
        type=findViewById(R.id.multiple_type);
        when=findViewById(R.id.multiple_when);
        where=findViewById(R.id.multiple_where);
        why=findViewById(R.id.multiple_why);
        duocha=findViewById(R.id.multiple_duocha);
        //2.设置点击事件
        duocha.setOnClickListener(this);//查询

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.multiple_duocha:
                String airname = name.getText().toString().trim();
                String airtype = type.getText().toString().trim();
                String airwhen = when.getText().toString().trim();
                String airwhere = where.getText().toString().trim();
                String airwhy = why.getText().toString().trim();
                if (airname.equals(""))
                {
                    Toast.makeText(this, "请输入事故名称", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (airtype.equals(""))
                {
                    Toast.makeText(this, "请输入事故类型", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (airwhen.equals(""))
                {
                    Toast.makeText(this, "请输入事故时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (airwhere.equals(""))
                {
                    Toast.makeText(this, "请输入事故地点", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (airwhy.equals(""))
                {
                    Toast.makeText(this, "请输入事故原因", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent =new Intent(this,DuoListActivity.class);
                intent.putExtra("airname",airname);
                intent.putExtra("airtype",airtype);
                intent.putExtra("airwhen",airwhen);
                intent.putExtra("airwhere",airwhere);
                intent.putExtra("airwhy",airwhy);
                startActivity(intent);
                break;
        }
    }
}
