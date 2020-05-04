package com.example.airaccident.Other.PicInfo.Bean;

import java.io.Serializable;

public class AirBean implements Serializable {//可以序列化
    private String title;
    private String desc;
    private int picId;

    public AirBean(String title, String desc, int picId) {
        this.title = title;
        this.desc = desc;
        this.picId = picId;
    }

    public AirBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }
}
