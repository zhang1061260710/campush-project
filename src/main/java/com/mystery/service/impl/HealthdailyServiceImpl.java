package com.mystery.service.impl;

import com.mystery.dao.HealthdailyMapper;
import com.mystery.entity.Healthdaily;
import com.mystery.service.IHealthdailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthdailyServiceImpl implements IHealthdailyService {
    @Autowired
    private HealthdailyMapper healthdailyMapper;
    @Override
    public List<Healthdaily> listuser() {
        return healthdailyMapper.listuser();
    }

    @Override
    public List<Healthdaily> query(String datemin, String datemax, String QueryContent) {
        return healthdailyMapper.query(datemin,datemax,QueryContent);
    }
}
