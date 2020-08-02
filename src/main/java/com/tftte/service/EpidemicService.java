package com.tftte.service;

import com.tftte.bean.DailyEpidemicInfo;
import com.tftte.bean.EpidemicDetailInfo;
import com.tftte.bean.ProvinceInfo;

import java.util.List;

/**
 * @Author: tftte
 * @Date: 2020/8/2 19:59
 * @Description:
 */
public interface EpidemicService {

    /**
     * 保存当日的疫情数据，返回还未录入数据的省份列表
     * @param dailyEpidemicInfo
     * @param userId
     * @return
     */
    List<ProvinceInfo> saveData(DailyEpidemicInfo dailyEpidemicInfo, Integer userId);

    /**
     * 获取最新的疫情数据
     * @return
     */
    List<EpidemicDetailInfo> findLastestData();
}
