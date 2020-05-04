package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.airaccident.R;

public class ReasonActivity extends AppCompatActivity {
    TextView tv_1,tv_2,tv_3,tv_4;
    TextView tv_5,tv_6,tv_7,tv_8;
    TextView tv_9,tv_10,tv_11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);
        tv_1=findViewById(R.id.tv_1);
        tv_2=findViewById(R.id.tv_2);
        tv_3=findViewById(R.id.tv_3);
        tv_4=findViewById(R.id.tv_4);
        tv_5=findViewById(R.id.tv_5);
        tv_6=findViewById(R.id.tv_6);
        tv_7=findViewById(R.id.tv_7);
        tv_8=findViewById(R.id.tv_8);
        tv_9=findViewById(R.id.tv_9);
        tv_10=findViewById(R.id.tv_10);
        tv_11=findViewById(R.id.tv_11);


        tv_1.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_1.getText().toString().trim());
            startActivity(intent);
        });
        tv_2.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_2.getText().toString().trim());
            startActivity(intent);
        });
        tv_3.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_3.getText().toString().trim());
            startActivity(intent);
        });
        tv_4.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_4.getText().toString().trim());
            startActivity(intent);
        });
        tv_5.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_5.getText().toString().trim());
            startActivity(intent);
        });
        tv_6.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_6.getText().toString().trim());
            startActivity(intent);
        });
        tv_7.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_7.getText().toString().trim());
            startActivity(intent);
        });
        tv_8.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_8.getText().toString().trim());
            startActivity(intent);
        });

        tv_9.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_9.getText().toString().trim());
            startActivity(intent);
        });
        tv_10.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_10.getText().toString().trim());
            startActivity(intent);
        });
        tv_11.setOnClickListener(view -> {
            Intent intent = new Intent(this,ReasonSecondActivity.class);
            intent.putExtra("airwhy",tv_11.getText().toString().trim());
            startActivity(intent);
        });
    }
}
