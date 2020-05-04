package com.example.airaccident.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.airaccident.R;
public class SplashActivity extends AppCompatActivity {

    TextView textView;
    int time = 3;//声明时间有3秒;
    LinearLayout skip;
    Animation animation;
    int count=0;
    SharedPreferences preferences=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //开启全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        textView=findViewById(R.id.textView);
        skip=findViewById(R.id.skip);
        skip.setOnClickListener(new mClick());//点击跳过
        preferences= getSharedPreferences("count", 0); // 存在则打开它，否则创建新的Preferences
        count = preferences.getInt("count", 0); // 取出数据,如果没有默认为0

        animation = AnimationUtils.loadAnimation(this, R.anim.countdown);
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    //计算Welcome界面的广告时间结束后进入主界面的方法
    private int getTime() {
        time--;
        if (time == 0) {
            if(count!=0){
                Intent intent1 = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent1);
            }
            else {
                Intent intent2 = new Intent();
                intent2.setClass(SplashActivity.this, GuideActivity.class);
                startActivity(intent2);
                //实例化Editor对象
                SharedPreferences.Editor editor = preferences.edit();
                //存入数据
                editor.putInt("count", 1); // 存入数据
                //提交修改
                editor.commit();
            }
            finish();
        }
        return time;
    }

    //进行一个消息的处理
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0) {
                textView.setText(getTime()+"");
                handler.sendEmptyMessageDelayed(0, 1000);
                animation.reset();
                textView.startAnimation(animation);
            }
        };

    };

    private class mClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            time=1;
            getTime();
        }
    }
}