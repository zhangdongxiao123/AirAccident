package com.example.airaccident.Other.History;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.airaccident.Other.History.contentbase.BaseActivity;
import com.example.airaccident.Other.History.contentbase.ContentURL;
import com.example.airaccident.Other.History.hisbean.HistoryBean;
import com.example.airaccident.Other.History.hisbean.LaoHuangLiBean;
import com.example.airaccident.R;
import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HistoryActivity extends BaseActivity implements View.OnClickListener {
    private ListView historyLv;
    private ImageButton imgBtn;
    List<HistoryBean.ResultBean> mdatas;
    private HistoryAdapter adapter;
    private Calendar calendar;
    private Date date;
    HistoryBean historyBean;
    //声明头布局当中的TextView
    TextView yinliTv,dayTv,weekTv,yangliTv,baijiTv,wuxingTv,chongshaTv,jishenTv,xiongshenTv,yiTv,jiTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        historyLv=(ListView)findViewById(R.id.history_lv);
        imgBtn=(ImageButton) findViewById(R.id.history_imgbtn);
        imgBtn.setOnClickListener((View.OnClickListener) this);

        mdatas=new ArrayList<>();
        adapter=new HistoryAdapter(this,mdatas);
        historyLv.setAdapter(adapter);
        //获取日历对象
       calendar= Calendar.getInstance();
       date=new Date();
       calendar.setTime(date);
       int month=calendar.get(Calendar.MONTH)+1;
       int day=calendar.get(Calendar.DAY_OF_MONTH);
       addHeaderAndFooterView();
       //获取网址
        String todayHistoryURL=ContentURL.getTodayHistoryURL("1.0",month,day);
        loadData(todayHistoryURL);
        historyLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(HistoryActivity.this,HistoryDescActivity.class);
                HistoryBean.ResultBean resultBean=mdatas.get(position-1);
                String bean_id = resultBean.get_id();
                intent.putExtra("hisId",bean_id);
                startActivity(intent);
            }
        });

    }

    private void addHeaderAndFooterView() {
        //给ListView添加头尾布局函数
        View headerView= LayoutInflater.from(this).inflate(R.layout.history_headerview,null);
        initHeaderView(headerView);
        historyLv.addHeaderView(headerView);
        View footerView=LayoutInflater.from(this).inflate(R.layout.history_footer,null);
        footerView.setTag("footer");
        footerView.setOnClickListener(this);
        historyLv.addFooterView(footerView);
    }

    private void initHeaderView(View headerView) {
        //初始化ListView头布局当中的每一个控件
        yinliTv=headerView.findViewById(R.id.history_header_tv_nongli);
        dayTv=headerView.findViewById(R.id.history_header_tv_day);
        weekTv=headerView.findViewById(R.id.history_header_tv_week);
        yangliTv=headerView.findViewById(R.id.history_header_tv_yangli);
        baijiTv=headerView.findViewById(R.id.history_header_tv_baiji);
        wuxingTv=headerView.findViewById(R.id.history_header_tv_wuxing);
        chongshaTv=headerView.findViewById(R.id.history_header_tv_chongsha);
        jishenTv=headerView.findViewById(R.id.history_header_tv_jishen);
        xiongshenTv=headerView.findViewById(R.id.history_header_tv_xiongshen);
        yiTv=headerView.findViewById(R.id.history_header_tv_yi);
        jiTv=headerView.findViewById(R.id.history_header_tv_ji);
        //将日期对象转换成指定格式的字符串形式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf.format(date);
        String laohuangliURL=ContentURL.getLaoHuangLiURL(time);
        loadHeaderData(laohuangliURL);



    }

    private void loadHeaderData(String laohuangliURL) {
        //获取老黄历接口数据
        RequestParams params=new RequestParams(laohuangliURL);
        x.http().get(params, new CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                LaoHuangLiBean huangLiBean=new Gson().fromJson(result, LaoHuangLiBean.class);
                LaoHuangLiBean.ResultBean resultBean=huangLiBean.getResult();
                yinliTv.setText("农历"+resultBean.getYinli()+"（阴历）");
                String[]yangliArr=resultBean.getYangli().split("-");
                String week=getWeek(Integer.parseInt(yangliArr[0]),Integer.parseInt(yangliArr[1]),Integer.parseInt(yangliArr[2]));
                yangliTv.setText("公历"+yangliArr[0]+"年"+yangliArr[1]+"月"+yangliArr[2]+"日"+week+"（阳历）");
                dayTv.setText(yangliArr[2]);
                weekTv.setText(week);
                baijiTv.setText("彭祖百忌："+resultBean.getBaiji());
                wuxingTv.setText("五行："+resultBean.getWuxing());
                chongshaTv.setText("冲煞："+resultBean.getChongsha());
                jishenTv.setText("吉神宜趋："+resultBean.getJishen());
                xiongshenTv.setText("凶神宜忌："+resultBean.getXiongshen());
                yiTv.setText("宜："+resultBean.getYi());
                jiTv.setText("忌"+resultBean.getJi());
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
        });
    }

    private String getWeek(int year, int month, int day) {
        //根据年月日获取对应的星期
        Calendar calendar=Calendar.getInstance();
        calendar.set(year,month-1,day);
        String weeks[]={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        int index=calendar.get(Calendar.DAY_OF_WEEK)-1;
        if(index<0){
            index=0;
        }
        return weeks[index];
    }

    @Override
    public void onSuccess(String result) {
        mdatas.clear();
        historyBean=new Gson().fromJson(result,HistoryBean.class);
        List<HistoryBean.ResultBean> list = historyBean.getResult();
        for (int i = 0; i < 5; i++) {
            mdatas.add(list.get(i));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.history_imgbtn) {
            popCalendarDialog();
            return;
        }
        String tag=(String) v.getTag();
        if (tag.equals("footer")) {
            Intent intent=new Intent(this,HistoryDesActivity.class);
            if(historyBean!=null) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("history",historyBean);
                intent.putExtras(bundle);
            }
            startActivity(intent);
        }
    }

    private void popCalendarDialog() {
        //弹出日期对话框
        Calendar calendar=Calendar.getInstance();
        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //改变老黄历上显示的内容
                String time=year+"-"+(month+1)+"-"+dayOfMonth;
                String laoHuangLiURL=ContentURL.getLaoHuangLiURL(time);
                loadHeaderData(laoHuangLiURL);
                //改变历史上的今天的数据
                String todayHistoryURL=ContentURL.getTodayHistoryURL("1.0",(month+1),dayOfMonth);
                loadData(todayHistoryURL);
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }
}
