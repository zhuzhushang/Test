package com.uyac.test.model;

/**
 * Created by Administrator on 2017/2/5.
 */

public class ImgShowModel {

    private int viewType;
    private int img[] ;
    private String date;


    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public int[] getImg() {
        return img;
    }

    public void setImg(int[] img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
