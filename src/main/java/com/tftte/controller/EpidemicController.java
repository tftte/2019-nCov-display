package com.tftte.controller;

import com.tftte.bean.*;
import com.tftte.service.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: tftte
 * @Date: 2020/8/2 20:27
 * @Description:
 */
@Controller
@RequestMapping("/epidemicData")
public class EpidemicController {
    @Autowired
    private EpidemicService epidemicService;

    @RequestMapping("/ajax/input")
    @ResponseBody
    public AjaxResponseInfo inputData(
            @RequestBody DailyEpidemicInfo dailyEpidemicInfo,
            Model model, HttpSession session) {
        AjaxResponseInfo responseInfo = new AjaxResponseInfo();
        // 从session中获取当前登录系统的用户信息
        UserInfo user = (UserInfo) session.getAttribute("loginUser");
        if (user == null) {
            responseInfo.setCode(-2);
            responseInfo.setMsg("请先登录!");
        } else {
            List<ProvinceInfo> list = epidemicService.saveData(dailyEpidemicInfo, user.getUserId());
            responseInfo.setData(list);
        }
        return responseInfo;
    }

    /**
     * 查询最新疫情信息
     * @return
     */
    @ResponseBody
    @GetMapping("/ajax/latestData")
    public AjaxResponseInfo findLatestData() {
        AjaxResponseInfo responseInfo = new AjaxResponseInfo();
        List<EpidemicDetailInfo> list = epidemicService.findLastestData();
        responseInfo.setData(list);
        return responseInfo;
    }
}
