package com.example.airaccident.Other.PicInfo.AirList;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.airaccident.Other.PicInfo.AirDescActivity;
import com.example.airaccident.R;
import com.example.airaccident.Other.PicInfo.Bean.AirBean;
import com.example.airaccident.Other.PicInfo.Bean.AirUtils;

import java.util.ArrayList;
import java.util.List;

public class InfoListActivity extends AppCompatActivity implements View.OnClickListener {
    EditText searchEt;
    ImageView searchIv,flushIv;
    ListView showLv;
    //先把ListView的内部数据源写好
    List<AirBean> mDatas;
    //获取全部数据
    List<AirBean> allAirList;
    private InfoListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);
        //查找控件
        initView();
        //找到ListView对应的数据源
        mDatas = new ArrayList<>();
            //获取全部数据
        allAirList= AirUtils.getAllAirList();
            //将全部信息添加到指定数据源mDatas中
        mDatas.addAll(allAirList);
        //创建适配器 BaseAdapter的子类
        adapter=new InfoListAdapter(this,mDatas);
        //设置适配器
        showLv.setAdapter(adapter);
        //设置ListView的单向点击监听功能
        setListener();

    }

    private void setListener() {
        showLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AirBean airBean=mDatas.get(position);
                Intent intent=new Intent(InfoListActivity.this, AirDescActivity.class);
                intent.putExtra("air",airBean);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        searchEt=findViewById(R.id.info_et_search);
        searchIv=findViewById(R.id.info_iv_search);
        flushIv =findViewById(R.id.info_iv_flush);
        showLv = findViewById(R.id.infolist_lv);
        //添加点击事件的监听器
        searchIv.setOnClickListener(this);
        flushIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.info_iv_flush://刷新点击
                searchEt.setText("");
                mDatas.clear();
                mDatas.addAll(allAirList);
                adapter.notifyDataSetChanged();
                break;
            case R.id.info_iv_search://搜索点击
                //1、获取输入信息,判断不为空
                String msg=searchEt.getText().toString().trim();
                if(TextUtils.isEmpty(msg)){
                    Toast.makeText(this,"输入内容不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                //2、判断所有的事件列表的标题是否包含输入的内容，如果包含，就添加到小的list集合里
                List<AirBean> list = new ArrayList<>();
                for (int i = 0; i < allAirList.size(); i++){
                    String title =allAirList.get(i).getTitle();
                    if(title.contains(msg)){
                        list.add(allAirList.get(i));
                    }
                }
                //清空listView传入到适配器中的内容
                mDatas.clear();
                //添加新的数据源
                mDatas.addAll(list);
                //提示适配器更新
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
