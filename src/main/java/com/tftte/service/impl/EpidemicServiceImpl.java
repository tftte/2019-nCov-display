package com.tftte.service.impl;

import com.tftte.bean.DailyEpidemicInfo;
import com.tftte.bean.EpidemicDetailInfo;
import com.tftte.bean.EpidemicInfo;
import com.tftte.bean.ProvinceInfo;
import com.tftte.mapper.EpidemicMapper;
import com.tftte.mapper.ProvinceMapper;
import com.tftte.service.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: tftte
 * @Date: 2020/8/2 20:03
 * @Description:
 */

@Service
@Transactional
public class EpidemicServiceImpl implements EpidemicService {

    @Autowired
    private EpidemicMapper epidemicMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    /**
     * 保存当日的疫情数据，返回还未录入数据的省份列表
     * @param dailyEpidemicInfo
     * @param userId
     * @return
     */
    @Override
    public List<ProvinceInfo> saveData(DailyEpidemicInfo dailyEpidemicInfo, Integer userId) {
        // 获取当前数据，跟系统时间一致
        Date current = new Date();
        // 数据的日期
        String[] ymd = dailyEpidemicInfo.getDate().split("-");
        short year = Short.parseShort(ymd[0]);
        short month = Short.parseShort(ymd[1]);
        short day = Short.parseShort(ymd[2]);
        for (EpidemicInfo epidemicInfo : dailyEpidemicInfo.getList()) {
            epidemicInfo.setUserId(userId);
            epidemicInfo.setInputDate(current);
            epidemicInfo.setDataYear(year);
            epidemicInfo.setDataMonth(month);
            epidemicInfo.setDataDay(day);
            epidemicMapper.saveInfo(epidemicInfo);
        }
        return provinceMapper.findNoDataProvince(year, month, day);
    }

    /**
     * 获取最新的疫情数据
     * @return
     */
    @Override
    public List<EpidemicDetailInfo> findLastestData() {
        // 查询每个省份的累计数量和当日新增数量
        Calendar calendar = new GregorianCalendar();
        short year = (short) calendar.get(Calendar.YEAR);
        short month = (short) (calendar.get(Calendar.MONTH) + 1);
        short day = (short) calendar.get(Calendar.DATE);

        Map<String, Short> condition = new HashMap<>();
        condition.put("year", year);
        condition.put("month", month);
        condition.put("day", day);

        // 查询每个省份的累计数量和当日新增量
        return epidemicMapper.findLastestData(condition);
    }
}
