package com.example.airaccident.My.Db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class User extends SQLiteOpenHelper {
    //数据库辅助类构造方法，当数据库存在时，直接返回，否则就创建数据库，并调用onCreate（）初始化数据库
    //上下文，数据库名称，游标工厂对象，当前数据库版本号；
    //只传上下文环境参数，其余参数固定写死
    public User(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "User.db", null, 1);
    }
//public User(Context context) {super(context, "User.db", null, 1);}

    /**
     * 数据库第一次创建的时候调用，在此方法中创建数据表
     * @param db
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库中的表
        db.execSQL("create table user(id integer primary key autoincrement,username varchar(30),userpwd varchar(50));");

    }

    /**
     * 当前数据库的版本号升级时调用的方法
     * @param db
     * @param oldVersion
     * @param newVersion
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
