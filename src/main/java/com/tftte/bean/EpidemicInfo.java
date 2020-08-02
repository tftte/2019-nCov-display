package com.tftte.bean;

import java.util.Date;

/**
 * @Author: tftte
 * @Date: 2020/8/2 10:47
 * @Description: 疫情信息
 */
public class EpidemicInfo {
    private Integer serialId;
    private Integer provinceId;
    private Short dataYear;
    private Short dataMonth;
    private Short dataDay;

    // 新增的
    private Integer affirmed;
    private Integer suspected;
    private Integer cured;
    private Integer isolated;
    private Integer dead;

    // 用户编号
    private Integer userId;

    // 数据录入时间
    private Date inputDate;

    public Integer getSerialId() {
        return serialId;
    }

    public void setSerialId(Integer serialId) {
        this.serialId = serialId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Short getDataYear() {
        return dataYear;
    }

    public void setDataYear(Short dataYear) {
        this.dataYear = dataYear;
    }

    public Short getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(Short dataMonth) {
        this.dataMonth = dataMonth;
    }

    public Short getDataDay() {
        return dataDay;
    }

    public void setDataDay(Short dataDay) {
        this.dataDay = dataDay;
    }

    public Integer getAffirmed() {
        return affirmed;
    }

    public void setAffirmed(Integer affirmed) {
        this.affirmed = affirmed;
    }

    public Integer getSuspected() {
        return suspected;
    }

    public void setSuspected(Integer suspected) {
        this.suspected = suspected;
    }

    public Integer getCured() {
        return cured;
    }

    public void setCured(Integer cured) {
        this.cured = cured;
    }

    public Integer getIsolated() {
        return isolated;
    }

    public void setIsolated(Integer isolated) {
        this.isolated = isolated;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }
}
