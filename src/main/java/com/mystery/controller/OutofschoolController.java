package com.mystery.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mystery.entity.Outofschool;
import com.mystery.service.IOutofschoolService;
import com.mystery.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Outofschool")
public class OutofschoolController {
    @Autowired
    private IOutofschoolService outofschoolService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value="/getall",method = RequestMethod.GET)
    public String getall(){
        List<Outofschool> getall = outofschoolService.getall(null);
        SerializeFilter scriptArrayFilter = null;
        String jsonStr = JSONObject.toJSONString(getall,new SerializeFilter[]{scriptArrayFilter}, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonStr);
        return jsonStr;
    }
}
