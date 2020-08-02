package com.tftte.controller;

import com.tftte.bean.AjaxResponseInfo;
import com.tftte.bean.ProvinceInfo;
import com.tftte.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: tftte
 * @Date: 2020/8/2 11:39
 * @Description:
 */
@Controller
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/ajax/noDataList")
    @ResponseBody
    public AjaxResponseInfo noDataProvinceList(String date) {
        AjaxResponseInfo<List<ProvinceInfo>> responseInfo = new AjaxResponseInfo<>();
        if (date != null && !"".equals(date)) {
            List<ProvinceInfo> list  = provinceService.findNoDataProvince(date);
            responseInfo.setData(list);
        } else {
            responseInfo.setCode(-1);
            responseInfo.setMsg("参数不足!");
        }
        return responseInfo;

    }
}
