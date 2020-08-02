package com.tftte.bean;

/**
 * @Author: tftte
 * @Date: 2020/8/2 10:55
 * @Description: 省份实体类
 */
public class ProvinceInfo {
    private Integer provinceId;
    private String provinceName;
    private String provincePy;

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvincePy() {
        return provincePy;
    }

    public void setProvincePy(String provincePy) {
        this.provincePy = provincePy;
    }
}
