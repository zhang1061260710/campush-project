package com.mystery.dao;


import com.mystery.entity.Healthdaily;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthdailyMapper {
    List <Healthdaily> listuser();
    List<Healthdaily> query(@Param("datemin") String datemin,@Param("datemax") String datemax);
}
