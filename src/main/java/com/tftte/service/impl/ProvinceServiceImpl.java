package com.tftte.service.impl;

import com.tftte.bean.ProvinceInfo;
import com.tftte.mapper.ProvinceMapper;
import com.tftte.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: tftte
 * @Date: 2020/8/2 11:34
 * @Description: 访问省份的Service
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    /**
     * 获取还未录入数据的省份信息
     * @param date
     * @return
     */
    @Override
    public List<ProvinceInfo> findNoDataProvince(String date) {
        String[] split = date.split("-");
        if (split.length < 3) {
            return null;
        }
        short year = Short.parseShort(split[0]);
        short month = Short.parseShort(split[1]);
        short day = Short.parseShort(split[2]);
        return provinceMapper.findNoDataProvince(year, month, day);
    }
}
