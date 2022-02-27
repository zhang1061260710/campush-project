package com.mystery.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mystery.entity.Healthdaily;
import com.mystery.entity.Response;
import com.mystery.service.IHealthdailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        return jsonStr;
    }

    @RequestMapping(value="/query", method = RequestMethod.POST)
    public void query(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        /*resp.setHeader("content-type","application/json; charset=UTF-8");*/
        resp.setContentType("application/json;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String DateMin=req.getParameter("datemin");
        String DateMax=req.getParameter("datemax");
        String QueryContent=req.getParameter("querycontent");
        List<Healthdaily> QueryDate =iHealthdailyService.query(DateMin,DateMax,QueryContent);
        SerializeFilter scriptArrayFilter = null;
        String jsonStr = JSONObject.toJSONString(QueryDate,new SerializeFilter[]{scriptArrayFilter}, SerializerFeature.WriteMapNullValue);
        resp.getWriter().print(jsonStr);
    }

    @RequestMapping(value = "/SaveDaily", method = RequestMethod.POST)
    public Response register(@RequestBody Healthdaily healthdaily) throws ServletException, IOException {
        System.out.println(healthdaily);
        return null;
    }
}
