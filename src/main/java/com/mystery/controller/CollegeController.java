package com.mystery.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mystery.entity.College;
import com.mystery.service.ICollegeService;
import org.apache.log4j.net.SyslogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private ICollegeService collegeService;
    //获取学院信息
    @RequestMapping(value = "/listAll")
    public void ListAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<College> college=collegeService.CollegeList();
   /*     String transformation = "";
        for (College list : college) {
            System.out.println(list.getId());
            System.out.println(list.getName());
            SerializeFilter scriptArrayFilter = null;
            String jsonStr = JSONObject.toJSONString(list,new SerializeFilter[]{scriptArrayFilter}, SerializerFeature.WriteMapNullValue);
            transformation += jsonStr;
        }*/
        SerializeFilter scriptArrayFilter = null;
        String jsonStr = JSONObject.toJSONString(college,new SerializeFilter[]{scriptArrayFilter}, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonStr);
        /*resp.getWriter().print(JSON.parseObject(jsonStr));*/
        resp.getWriter().print(jsonStr);
    }
    //根据ID删除学院
    @RequestMapping(value = "/dele" ,method = RequestMethod.POST)
    public String deleCollege(String id){
        int newid=Integer.parseInt(id);
        try {
            collegeService.dele(newid);
        }catch (Exception e){
            return "sql error";
        }
        return "ok";
    }

    //新增学院
    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public String saveCollege(String name){
        try {
            System.out.println(name);
            collegeService.save(name);
        }catch (Exception e){
            return "sql error";
        }
        return "ok";
    }
    @RequestMapping(value="/getUsername",produces = "text/plain;charset=utf-8")
    public String getname (){
        return "hello";
    }
}
