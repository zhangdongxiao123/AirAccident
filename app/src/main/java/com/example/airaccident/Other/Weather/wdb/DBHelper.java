package com.example.airaccident.Other.Weather.wdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //构造数据库方法
    public DBHelper(Context context){
        super(context,"forecast.db",null,1);
    }
    //第一次创建数据库时执行的方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表的操作
        String sql="create table info(" +
                "_id integer primary key autoincrement," +
                "city varchar(20) unique not null," +
                "content text not null)";
        //执行语句
        db.execSQL(sql);
    }
   //数据库版本更新时执行的方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
