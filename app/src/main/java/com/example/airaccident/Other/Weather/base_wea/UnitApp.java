package com.example.airaccident.Other.Weather.base_wea;

import android.app.Application;

import com.example.airaccident.Other.Weather.wdb.DBManager;

import org.xutils.x;

public class UnitApp extends Application {
    //在onCreate()方法中声明整体模块
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);//全局声明
        DBManager.initDB(this);//初始化数据库
    }
}
