package com.mystery.service;

import com.mystery.entity.Healthdaily;

import java.util.List;

public interface IHealthdailyService {
    List<Healthdaily> listuser();

    List<Healthdaily> query(String datemin,String datemax,String QueryContent);
}
