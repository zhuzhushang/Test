package com.uyac.test.model;

import java.util.List;

/**
 * Created by ShaoQuanwei on 2016/11/1.
 */

public class City {

    private String areacode;
    private String areaname;
    private String parentcode;
    private List<Area> cata;

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

    public List<Area> getCata() {
        return cata;
    }

    public void setCata(List<Area> cata) {
        this.cata = cata;
    }

    public String getPickerViewText()
    {
        return areaname;
    }


}
