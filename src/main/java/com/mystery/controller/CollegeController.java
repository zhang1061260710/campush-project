package com.mystery.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mystery.entity.College;
import com.mystery.entity.Response;
import com.mystery.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
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
        /*resp.getWriter().print(JSON.parseObject(jsonStr));*/
        resp.getWriter().print(jsonStr);
    }
    //根据ID删除学院
    @RequestMapping(value = "/dele" ,method = RequestMethod.POST)
    public Response deleCollege(String id){
        int newid=Integer.parseInt(id);
        try {
            collegeService.dele(newid);
            return Response.OK(null);
        }catch (Exception e){
            return Response.Error();
        }
    }

    //新增学院
    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public Response saveCollege(String name){
        try {
            collegeService.save(name);
            return Response.OK(null);
        }catch (Exception e){
            return Response.Error();
        }
    }
    //批量删除
    @RequestMapping(value = "/batchDelete",method = RequestMethod.POST)
    public Response batchDelete(@RequestParam("userIds[]") Integer[] userIds) {
        List<Integer> userIdList = Arrays.asList(userIds);
        try{
            collegeService.batchDelete(userIdList);
            return Response.OK(null);
        }catch (Exception e){
            return Response.Error();
        }
    }

    //根据ID查询
    @RequestMapping(value = "/IdQuery",method = RequestMethod.POST)
    public  Response IdQuery(@RequestParam("id")int id){
        try {
            College college=collegeService.queryById(id);
            return Response.OK(college);
        }catch (Exception e){
            return Response.Error();
        }
    }
    //编辑
    @RequestMapping(value = "/UpdataCollege",method = RequestMethod.POST)
    public Response UpdataCollege(@RequestBody College college){
        collegeService.UpdataByCollegeName(college);
        System.out.println(college.getName());
        System.out.println(college.getId());
        return Response.OK(college);
    }

    @RequestMapping(value="/getUsername",produces = "text/plain;charset=utf-8")
    public String getname (){
        return "hello";
    }

}
