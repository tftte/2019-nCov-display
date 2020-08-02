package com.tftte.bean;

import java.util.List;

/**
 * @Author: tftte
 * @Date: 2020/8/2 10:58
 * @Description:
 */
public class DailyEpidemicInfo {
    private String date;
    private List<EpidemicInfo> list; // 多个省的疫情信息

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<EpidemicInfo> getList() {
        return list;
    }

    public void setList(List<EpidemicInfo> list) {
        this.list = list;
    }
}
