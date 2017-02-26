package com.uyac.test.model;

/**
 * Created by ShaoQuanwei on 2016/11/1.
 */

public class Area {

    private String areacode;
    private String areaname;
    private String parentcode;

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public String getPickerViewText()
    {
        return areaname;
    }
}
