package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.airaccident.R;
import com.knifestone.hyena.currency.InputFilterAdapter;
import com.knifestone.hyena.currency.TextWatcherAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import static com.example.airaccident.app.Url.login;

public class ManLoginActivity extends AppCompatActivity {
    EditText manAcount,manPassword;
    Button manLogin;
    TextView mima,zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_login);
        //1.绑定控件
        manAcount=(EditText)findViewById(R.id.manAccount);
        manPassword=(EditText)findViewById(R.id.manPassword);
        manLogin=(Button)findViewById(R.id.manLogin);
        mima=(TextView)findViewById(R.id.man_mima);
        zhuce=(TextView)findViewById(R.id.man_zhuce);
        //2.设置过滤，账号输入框只能输入字母、数字、符号、中文，过滤表情
        InputFilterAdapter inputFilter=new InputFilterAdapter
                .Builder()
                .filterEmoji(true)
                .builder();
        manAcount.setFilters(new InputFilter[]{inputFilter});
        //3.设置过滤，密码输入框只能输入字母、数字、符号，过滤表情和中文
        InputFilterAdapter inputFilter1=new InputFilterAdapter
                .Builder()
                .filterEmoji(true)
                .filterChinese(true)
                .builder();
        manPassword.setFilters(new InputFilter[]{inputFilter1});
        //4.设置文本变化监听
        manAcount.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                checkSubmit();

            }
        });
        manPassword.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                checkSubmit();

            }
        });
        //5.设置点击事件
        initData();
    }
    //点击事件
    private void initData(){
        //监听登录
        manLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 登录逻辑写在这
                 */




                OkHttpUtils.post()
                        .url(login)
                        .addParams("username",manAcount.getText().toString().trim())
                        .addParams("password",manPassword.getText().toString().trim())
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(String response, int id) {
                                try {
                                    JSONObject jsonObject = JSON.parseObject(response);
                                    String status = jsonObject.getString("status");
                                    String msg = jsonObject.getString("msg");
                                    if (status.equals("0"))
                                    {
                                        Toast.makeText(ManLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(ManLoginActivity.this,ManSelectActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(ManLoginActivity.this, msg+"", Toast.LENGTH_SHORT).show();

                                    }



                                }catch (Exception e)
                                {

                                }
                            }
                        });
            }
        });
        //监听忘记密码
        mima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ManLoginActivity.this, ManPasswordActivity.class);
                startActivity(intent1);
            }
        });
        //监听注册
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(ManLoginActivity.this, ManRegistActivity.class);
                startActivity(intent2);
            }
        });
    }



    /**
     * 第一次跳转到管理员登录页面，按钮不能够后被点击
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
        String msg = manAcount.getText().toString().trim();
        if(TextUtils.isEmpty(msg)){
            manLogin.setEnabled(false);
            return;
        }
        msg = manPassword.getText().toString().trim();
        if(TextUtils.isEmpty(msg)){
            manLogin.setEnabled(false);
            return;
        }
        manLogin.setEnabled(true);
    }

    //重写返回按钮
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent();
            ManLoginActivity.this.setResult(2,intent);
            finish();
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
}
