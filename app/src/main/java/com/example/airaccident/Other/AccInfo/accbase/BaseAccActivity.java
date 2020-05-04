package com.example.airaccident.Other.AccInfo.accbase;

import androidx.appcompat.app.AppCompatActivity;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

//1.实现接口CommonCallback，返回数据String
public class BaseAccActivity extends AppCompatActivity implements Callback.CommonCallback<String> {
    //2.写一个函数，传入接口
    //3.初始化XUtils
    public void loadData1(String url){
        //4.把url传进去，封装到请求参数里
        RequestParams params=new RequestParams(url);
        //5.开始请求
        x.http().get(params,this);
    }
    @Override
    public void onSuccess(String result) {

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
