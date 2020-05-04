package com.example.airaccident.Other.AccInfo.accbase;

public class AccURL {
    //获取航空安全信息对应的网址
    public static String getAccURL(){
        String url="http://localhost:9000/Air_Server_war_exploded/InfoController?airkey=4";
        return url;
    }
}
