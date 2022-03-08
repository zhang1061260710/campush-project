package com.mystery.service.impl;

import com.mystery.dao.OutofschoolMapper;
import com.mystery.entity.Outofschool;
import com.mystery.service.IOutofschoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutofschoolServiceImpl implements IOutofschoolService {

    @Autowired
    private OutofschoolMapper outofschoolMapper;

    @Override
    public List<Outofschool> getall(String number) {
        return outofschoolMapper.getall(number);
    }

    @Override
    public void UpdateApproval(String number,String whether) {
        outofschoolMapper.UpdateApproval(number,whether);
    }

    @Override
    public void SaveAdd(Outofschool outofschool) {
        outofschoolMapper.SaveAdd(outofschool);
    }
}
