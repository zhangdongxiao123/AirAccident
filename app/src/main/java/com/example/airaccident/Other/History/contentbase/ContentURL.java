package com.example.airaccident.Other.History.contentbase;

public class ContentURL {
    //获取指定日期对应的历史上的今天的网址
    public static String getTodayHistoryURL(String version,int month,int day){
        String url="http://api.juheapi.com/japi/toh?v="+version+"&month="+month+"&day="+day+"&key=c508c5492394108385dfa35fac639830";
        return url;
    }
    //获取指定日期的老黄历的网址
    public static String getLaoHuangLiURL(String time){
        String url="http://v.juhe.cn/laohuangli/d?date="+time+"&key=4d6cde4b010691d04a2d60c388b7ebe0";
        return url;
    }
    //http://api.juheapi.com/japi/tohdet?key=c508c5492394108385dfa35fac639830&v=1.0&id=18851114
    //根据指定事件ID，获取指定事件详情信息
    public static String getHistoryDescURL(String version,String id){
        String url="http://api.juheapi.com/japi/tohdet?key=c508c5492394108385dfa35fac639830&v="+version+"&id="+id;
        return url;
    }
}
