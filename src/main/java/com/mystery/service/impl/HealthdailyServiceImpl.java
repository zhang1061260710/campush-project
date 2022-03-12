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

    @Override
    public void save(Healthdaily healthdaily) {
        healthdailyMapper.save(healthdaily);
    }

    @Override
    public void dele(int id) {
        healthdailyMapper.dele(id);
    }

    @Override
    public void UpdateWarning(String id, String warning) {
        healthdailyMapper.UpdateWarning(id,warning);
    }

    @Override
    public List<Healthdaily> AllWarning(String warning) {
        return healthdailyMapper.AllWarning(warning);
    }

    @Override
    public void deleWarning(int id) {
        healthdailyMapper.deleWarning(id);
    }

    @Override
    public List<Healthdaily> UserWarning(String number) {
        return healthdailyMapper.UserWarning(number);
    }

    @Override
    public void BatchDeleById(List<Integer> id) {
        healthdailyMapper.BatchDeleById(id);
    }

    @Override
    public Healthdaily QueryById(int id) {
        return healthdailyMapper.QueryById(id);
    }

    @Override
    public void EditUpdateById(Healthdaily healthdaily) {
        healthdailyMapper.EditUpdateById(healthdaily);
    }
}
