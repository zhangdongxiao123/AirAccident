package com.example.airaccident.Search.sactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import okhttp3.Call;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.example.airaccident.R;
import com.example.airaccident.app.glide.GlideEngineEx;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.EnumSet;
import java.util.LinkedHashMap;

import static com.example.airaccident.app.Url.airdetailadd;
import static com.example.airaccident.app.Url.upload;
import static com.zhihu.matisse.MimeType.JPEG;
import static com.zhihu.matisse.MimeType.PNG;

public class ManAddActivity extends AppCompatActivity implements View.OnClickListener {
    EditText id,name,type,when,where,why,how;
    ImageView img;
    Button tianjia;
    String imgurl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_add);
        //1.绑定控件
        id=findViewById(R.id.manadd_airid);
        name=findViewById(R.id.manadd_airname);
        type=findViewById(R.id.manadd_airtype);
        when=findViewById(R.id.manadd_airwhen);
        where=findViewById(R.id.manadd_airwhere);
        why=findViewById(R.id.manadd_airwhy);
        how=findViewById(R.id.manadd_airhow);
        img=findViewById(R.id.manadd_airimg);
        tianjia=findViewById(R.id.manadd_tianjia);
        //2.设置点击事件
        img.setOnClickListener(this);
        tianjia.setOnClickListener(this);

    }
    private static final int REQUEST_CODE_CHOOSE = 23;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.manadd_airimg:

                if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)) {
                    Matisse.from(this)
                            .choose(EnumSet.of(JPEG, PNG)) // 选择 mime 的类型
                            .theme(R.style.Matisse_Dracula)//Zhihu（亮蓝色主题） Dracula（黑色主题）
                            .countable(true) //countable()是否显示选中数量
                            //这两行要连用 是否在选择图片中展示照相 和适配安卓7.0 FileProvider
                            .capture(true)
                            .captureStrategy(new CaptureStrategy(true, getPackageName() + ".FileProvider"))
                            .maxSelectable(1) // 图片选择的最多数量
                            .spanCount(3)//网格的规格,一行显示几张图片
                            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)//图像选择和预览活动所需的方向。
                            .thumbnailScale(0.85f) // 缩略图的清晰程度(与内存占用有关)
                            .imageEngine(new GlideEngineEx()) // 使用的图片加载引擎
                            .forResult(12); // 设置作为标记的请求码

                } else {
                    //提示用户开户权限   拍照和读写sd卡权限
                    String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
                    ActivityCompat.requestPermissions(this, perms, RESULT_CODE_STARTCAMERA);
                }



                break;
            case R.id.manadd_tianjia:

                if (id.getText().toString().equals(""))
                {
                    Toast.makeText(this, "请输入id", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (name.getText().toString().equals(""))
                {
                    Toast.makeText(this, "请输入事故名称", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (type.getText().toString().equals(""))
                {
                    Toast.makeText(this, "请输入事故类型", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (when.getText().toString().equals(""))
                {
                    Toast.makeText(this, "请输入事故时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (where.getText().toString().equals(""))
                {
                    Toast.makeText(this, "请输入地点", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (why.getText().toString().equals(""))
                {
                    Toast.makeText(this, "请输入事故原因", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (how.getText().toString().equals(""))
                {
                    Toast.makeText(this, "请输入事故详情", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (imgurl.equals(""))
                {
                    Toast.makeText(this, "请上传图片", Toast.LENGTH_SHORT).show();
                    return;
                }

                //搜索请求事件
                OkHttpUtils.post()
                        .url(airdetailadd)
                        .addParams("airid",id.getText().toString())
                        .addParams("airname",name.getText().toString())
                        .addParams("airtype",type.getText().toString())
                        .addParams("airwhen",when.getText().toString())
                        .addParams("airwhere",where.getText().toString())
                        .addParams("airwhy",why.getText().toString())
                        .addParams("airhow",how.getText().toString())
                        .addParams("airimg",imgurl)
                        //.addParams("",)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(String response, int id) {
                                try {
                                    Log.e("请求的",response);
                                    JSONObject jsonObject = JSON.parseObject(response);
                                    String status  = jsonObject.getString("status");
                                    String msg  = jsonObject.getString("msg");
                                    if (status.equals("0"))
                                    {
                                        Toast.makeText(ManAddActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }else {
                                        Toast.makeText(ManAddActivity.this, msg+"", Toast.LENGTH_SHORT).show();
                                    }


                                }catch (Exception e)
                                {

                                }
                            }
                        });



                break;
        }
    }
    private final int RESULT_CODE_STARTCAMERA = 0xff1;    //相机

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12 && resultCode == RESULT_OK) {
            //List<Uri> result = Matisse.obtainPathResult(data).get(0);
            //图片路径
            String path = Matisse.obtainPathResult(data).get(0);

            Glide.with(this)
                    .load(path)
                    .into(img);
            try {
                LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                LinkedHashMap<String, String> paths = new LinkedHashMap<>();
                paths.put("file", path);
                com.example.airaccident.app.network.OkHttpUtils.ResultCallback<String> callback = new com.example.airaccident.app.network.OkHttpUtils.ResultCallback<String>() {
                    @Override
                    public void onSuccess(String response) {
                        JSONObject jsonObject = JSON.parseObject(response);
                        String status = jsonObject.getString("status");
                        String msg = jsonObject.getString("msg");
                        String data = jsonObject.getString("data");
                        imgurl = data;
                    }

                    @Override
                    public void onFailure(int code, String e) {

                    }
                };
                com.example.airaccident.app.network.OkHttpUtils.postFile(this, true, upload, linkedHashMap, paths,
                        callback, (currentBytes, contentLength, done) -> {

                        });

            } catch (Exception e) {
                e.printStackTrace();
            }




        }
    }


}
