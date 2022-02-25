package com.mystery.dao;


import com.mystery.entity.Healthdaily;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthdailyMapper {
    List <Healthdaily> listuser();
    List<Healthdaily> query(String datemin,String datemax,Integer querycontent);
}
