package com.example.airaccident.Other.Information;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.airaccident.R;

public class InfoFiveActivity extends AppCompatActivity {
    TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_five);

        textView5=(TextView)findViewById(R.id.five_text_view);
        textView5.setMovementMethod(ScrollingMovementMethod.getInstance());

    }
}
