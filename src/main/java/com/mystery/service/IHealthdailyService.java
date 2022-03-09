package com.mystery.service;

import com.mystery.entity.Healthdaily;

import java.util.List;

public interface IHealthdailyService {
    List<Healthdaily> listuser();

    List<Healthdaily> query(String datemin,String datemax,String QueryContent);

    void save(Healthdaily healthdaily);

    void dele (int id);

    void UpdateWarning (String id,String warning);

    List <Healthdaily> AllWarning(String warning);

    void deleWarning (int id);

    List<Healthdaily> UserWarning(String number);
}
