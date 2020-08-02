package com.tftte.service;

import com.tftte.bean.ProvinceInfo;

import java.util.List;

/**
 * @Author: tftte
 * @Date: 2020/8/2 11:30
 * @Description: 访问省份的Service
 */
public interface ProvinceService {
    /**
     * 获取还未录入数据的省份信息
     * @param date
     * @return
     */
    List<ProvinceInfo> findNoDataProvince(String date);
}
