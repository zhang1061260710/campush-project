package com.mystery.service.impl;


import com.mystery.dao.CollegeMapper;
import com.mystery.entity.College;
import com.mystery.service.ICollegeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServcieImpl implements ICollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> CollegeList() {
        return collegeMapper.CollegeList();
    }

    @Override
    public void dele(Integer id) {
        collegeMapper.dele(id);
    }

    @Override
    public void save(String name) {
        collegeMapper.save(name);
    }

    @Override
    public void batchDelete(List<Integer> userIds) {
        collegeMapper.batchDelete(userIds);
    }

    @Override
    public College queryById(int id) {
        return collegeMapper.queryById(id);
    }

    @Override
    public void UpdataByCollegeName(College college) {
        collegeMapper.UpdataByCollegeName(college);
    }
}
