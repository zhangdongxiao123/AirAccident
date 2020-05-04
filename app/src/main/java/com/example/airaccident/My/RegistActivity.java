package com.example.airaccident.My;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.airaccident.My.Db.UserDao;
import com.example.airaccident.R;
import com.knifestone.hyena.currency.InputFilterAdapter;
import com.knifestone.hyena.currency.TextWatcherAdapter;

public class RegistActivity extends AppCompatActivity {
    EditText acount,password;
    Button zhuce;
    UserDao mDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        //初始化
        acount=(EditText)findViewById(R.id.register_account);
        password=(EditText)findViewById(R.id.register_pwd);
        zhuce=(Button)findViewById(R.id.register_zhuce);
        //设置过滤，账号输入框只能输入字母、数字、符号、中文，过滤表情
        InputFilterAdapter inputFilter=new InputFilterAdapter
                .Builder()
                .filterEmoji(true)
                .builder();
        acount.setFilters(new InputFilter[]{inputFilter});
        //设置过滤，密码输入框只能输入字母、数字、符号，过滤表情和中文
        InputFilterAdapter inputFilter1=new InputFilterAdapter
                .Builder()
                .filterEmoji(true)
                .filterChinese(true)
                .builder();
        password.setFilters(new InputFilter[]{inputFilter1});
        //设置文本变化监听
        acount.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                checkSubmit();

            }
        });
        password.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                checkSubmit();

            }
        });
        initData();
    }
    //注册逻辑
    private void initData(){
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取数据
                String username=acount.getText().toString().trim();
                String userpwd=password.getText().toString().trim();
                //创建表
                mDao=new UserDao(getApplicationContext());
                if(mDao.find1(username)){
                    Toast.makeText(getApplicationContext(),"已经存在该账号",Toast.LENGTH_SHORT).show();
                }else {
                    //插入数据
                    mDao.insert(username,userpwd);
                    //提示
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    /**
     * 第一次跳转到注册页面，按钮不能够后被点击
     */

    @Override
    protected void onResume() {
        super.onResume();
        checkSubmit();
    }

    /**
     * 检测是否可以提交
     */
    private void checkSubmit(){
        String msg = acount.getText().toString().trim();
        if(TextUtils.isEmpty(msg)){
            zhuce.setEnabled(false);
            return;
        }
        msg = password.getText().toString().trim();
        if(TextUtils.isEmpty(msg)){
            zhuce.setEnabled(false);
            return;
        }
        zhuce.setEnabled(true);
    }
}
