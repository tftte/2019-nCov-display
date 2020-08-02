package com.tftte.mapper;

import com.tftte.bean.ProvinceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: tftte
 * @Date: 2020/8/2 11:01
 * @Description:
 */
@Mapper
public interface ProvinceMapper {

    /**
     * 根据日期查询对应的省份信息(根据疫情信息去查)
     * @param year
     * @param month
     * @param day
     * @return
     */
    @Select(value = "SELECT p.province_id,p.province_name,p.province_py FROM provinces p " +
            "  WHERE (p.del_flag IS NULL OR p.del_flag = 0) " +
            "  AND p.province_id NOT IN( " +
            "     SELECT e.province_id FROM epidemics e " +
            "     WHERE e.data_year=#{arg0} AND e.data_month=#{arg1} AND e.data_day =#{arg2}  " +
            "  ) ORDER BY p.province_id LIMIT 0,6")
    List<ProvinceInfo> findNoDataProvince(short year, short month, short day);
}
