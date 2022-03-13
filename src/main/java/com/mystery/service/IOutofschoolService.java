package com.mystery.service;

import com.mystery.entity.Outofschool;

import java.util.List;

public interface IOutofschoolService {
    List<Outofschool> getall (String number);

    //出校审核
    void UpdateApproval(String number,String whether);

    void  SaveAdd(Outofschool outofschool);
    //批量删除
    void BatchDeleOutoFschool(List<Integer> userIds);
}
