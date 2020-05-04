package com.example.airaccident.My;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.airaccident.My.Db.UserDao;
import com.example.airaccident.R;
import com.knifestone.hyena.currency.InputFilterAdapter;
import com.knifestone.hyena.currency.TextWatcherAdapter;

public class LoginActivity extends AppCompatActivity {
    EditText etAcount,etPassword;
    Button btnSubmit;
    TextView wangjimima,zhuce;
    UserDao mDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化
        etAcount=(EditText)findViewById(R.id.etAccount);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnSubmit=(Button)findViewById(R.id.login_btnSubmit);
        wangjimima=(TextView)findViewById(R.id.wangjimima);
        zhuce=(TextView)findViewById(R.id.zhuce);
        //设置过滤，账号输入框只能输入字母、数字、符号、中文，过滤表情
        InputFilterAdapter inputFilter=new InputFilterAdapter
                .Builder()
                .filterEmoji(true)
                .builder();
        etAcount.setFilters(new InputFilter[]{inputFilter});
        //设置过滤，密码输入框只能输入字母、数字、符号，过滤表情和中文
        InputFilterAdapter inputFilter1=new InputFilterAdapter
                .Builder()
                .filterEmoji(true)
                .filterChinese(true)
                .builder();
        etPassword.setFilters(new InputFilter[]{inputFilter1});
        //设置文本变化监听
        etAcount.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                checkSubmit();

            }
        });
        etPassword.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                checkSubmit();

            }
        });
        initData();
    }
    //注册逻辑
    private void initData(){
        //监听登录
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取数据
                String username=etAcount.getText().toString().trim();
                String userpwd=etPassword.getText().toString().trim();
                mDao=new UserDao(getApplicationContext());
                if(mDao.find(username,userpwd)){
                    Intent intent=new Intent();
                    Bundle bundle=new Bundle();
                    bundle.putString("name", username);
                    bundle.putString("pwd", userpwd);
                    intent.putExtras(bundle);
                    // 1是返回的requestCode
                    LoginActivity.this.setResult(1,intent);
                    //这里要直接干掉
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //监听忘记密码
        wangjimima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(LoginActivity.this, PasswordActivity.class);
                startActivity(intent1);
            }
        });
        //监听注册
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent2);
            }
        });
    }



    /**
     * 第一次跳转到登陆页面，按钮不能够后被点击
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
        String msg = etAcount.getText().toString().trim();
        if(TextUtils.isEmpty(msg)){
            btnSubmit.setEnabled(false);
            return;
        }
        msg = etPassword.getText().toString().trim();
        if(TextUtils.isEmpty(msg)){
            btnSubmit.setEnabled(false);
            return;
        }
        btnSubmit.setEnabled(true);
    }

  //重写返回按钮
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent();
            LoginActivity.this.setResult(2,intent);
            finish();
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
}
