package com.uyac.test.model;

import java.util.List;

/**
 * Created by ShaoQuanwei on 2016/11/1.
 */

public class SSQModel {

    private String lasttime;
    private String update;
    private String msg;
    private List<Province> list;


    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Province> getList() {
        return list;
    }

    public void setList(List<Province> list) {
        this.list = list;
    }
}
