package com.example.airaccident.My.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 操作数据库的类，对数据库进行增删查改
 */

public class UserDao {
    private UserDao mDao;
    private final User user;
    //执行构造方法，创建这个数据库和数据库表
    public UserDao(Context context) {
        user = new User(context, "User.db", null, 1);
    }

    /**
     *添加一个账号密码信息
     */
    public void insert(String username, String userpwd){
        //开启数据库，准备做写入操作
        SQLiteDatabase db=user.getWritableDatabase();
        //创建ContentValues对象封装键值对
        ContentValues values=new ContentValues();
        //封装键值对，要插入的字段名和字段值
        values.put("username",username);
        values.put("userpwd",userpwd);
        //插入数据库（表名，字段没有值时把字段维护成null，内容值）
        db.insert("user",null,values);
        //关闭数据库
        db.close();
    }

    /**
     * 修改密码
     * @param username
     * @param userpwd
     */
    public void update(String username, String userpwd) {
        //开启数据库，准备做写入操作
        SQLiteDatabase db = user.getWritableDatabase();
        //创建ContentValues对象封装键值对
        ContentValues values = new ContentValues();
        //封装键值对，要插入的字段名和字段值
        values.put("userpwd",userpwd);
        //更新数据库
        db.update("user", values, "username=?", new String[]{username});
        //关闭数据库
        db.close();
    }

    //查找数据库中的一个账号密码信息，其返回值用来判断数据库中是否存在该账号密码
    public boolean find(String username,String userpwd){
        //默认没有该数据
        boolean result=false;
        //开启数据库
        SQLiteDatabase db=user.getWritableDatabase();
        //查询所有账号密码（表名，查询的账号，查询条件没有-null）
        Cursor cursor=db.query("user",new String[]{"username","userpwd"},null,null,null,null,null);
       //如果游标能往下移动
        while (cursor.moveToNext()){
            //遍历对象，并且跟传入的账号密码进行比较，如果相同就返回true，说明数据库存在该数据
            if(username.equals(cursor.getString(0))){
                if(userpwd.equals(cursor.getString(1))){
                    result=true;
                }
            }
        }
        /**
         * 一定要关闭游标，回收游标对象
         */
        cursor.close();
        return result;
   }
    //查找数据库中的一个账号信息，其返回值用来判断数据库中是否存在该账号
    public boolean find1(String username){
        //默认没有该数据
        boolean result1=false;
        //开启数据库
        SQLiteDatabase db=user.getWritableDatabase();
        //查询所有账号密码（表名，查询的账号，查询条件没有-null）
        Cursor cursor=db.query("user",new String[]{"username"},null,null,null,null,null);
        //如果游标能往下移动
        while (cursor.moveToNext()){
            //遍历对象，并且跟传入的账号密码进行比较，如果相同就返回true，说明数据库存在该数据
            if(username.equals(cursor.getString(0))){
                result1=true;
            }
        }
        /**
         * 一定要关闭游标，回收游标对象
         */
        cursor.close();
        return result1;
    }



}
