package com.mystery.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mystery.entity.Healthdaily;
import com.mystery.service.IHealthdailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Healthdaily")
public class HealthdailyController {
    @Autowired
    private IHealthdailyService iHealthdailyService;

    @RequestMapping(value="/AllUserList", method = RequestMethod.GET)
    public String listAll(){
        List<Healthdaily> AllUser =iHealthdailyService.listuser();
        SerializeFilter scriptArrayFilter = null;
        String jsonStr = JSONObject.toJSONString(AllUser,new SerializeFilter[]{scriptArrayFilter}, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonStr);
        return jsonStr;
    }

    @RequestMapping(value="/query", method = RequestMethod.POST)
    public String query(){

        return null;
    }

}
