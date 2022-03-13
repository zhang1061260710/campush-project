package com.mystery.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mystery.entity.Outofschool;
import com.mystery.entity.Response;
import com.mystery.service.IOutofschoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Outofschool")
public class OutofschoolController {
    @Autowired
    private IOutofschoolService outofschoolService;
    @RequestMapping(value="/getall",method = RequestMethod.GET,produces = {"text/html;charset=utf-8"})
    public String getall(@RequestParam("number")String number){
        List<Outofschool> getall = outofschoolService.getall(number);
        SerializeFilter scriptArrayFilter = null;
        String jsonStr = JSONObject.toJSONString(getall,new SerializeFilter[]{scriptArrayFilter}, SerializerFeature.WriteMapNullValue);
        return jsonStr;
    }
    @RequestMapping(value="/UpdateApproval",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public Response UpdateApproval(@RequestParam("number")String number,@RequestParam("whether") String whether){
        outofschoolService.UpdateApproval(number,whether);
        return Response.OK(number);
    }
    @RequestMapping(value = "/SaveAdd",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public Response SaveAdd(@RequestBody Outofschool outofschool){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //时间格式
        String date= df.format(new Date());     //获取当前时间
        outofschool.setLeavetime(Timestamp.valueOf(date));
        List <Outofschool> judge= outofschoolService.getall(String.valueOf(outofschool.getNumber()));
        if (judge.size() ==0){
            outofschoolService.SaveAdd(outofschool);
            return Response.OK(outofschool);
        }else {
            return Response.Error();
        }
    }

    //批量删除（归校，过期申请）
    @RequestMapping(value = "/DeleOutoFschool",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public  Response  BatchDeleOutoFschool(@RequestParam("userIds[]") Integer[] userIds){
        try {
            List<Integer> userIdList = Arrays.asList(userIds);
            outofschoolService.BatchDeleOutoFschool(userIdList);
            return Response.OK(null);
        }catch (Exception e){
            return Response.Error();
        }
    }

}
