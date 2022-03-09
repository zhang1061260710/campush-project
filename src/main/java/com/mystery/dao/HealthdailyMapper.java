package com.mystery.dao;


import com.mystery.entity.Healthdaily;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthdailyMapper {
    //查询接口
    List <Healthdaily> listuser();
    //条件查询接口，其实没必要使用前面的"查询"接口可以直接使用这个条件查询接口，这里多写了。优化的话可以合并为一个接口
    List<Healthdaily> query(@Param("datemin") String datemin,@Param("datemax") String datemax,@Param("QueryContent")String QueryContent);
    //新增
    void save (Healthdaily healthdaily);
    //根据id进行删除
    void dele (int id);

    void UpdateWarning (@Param("id")String id,@Param("warning")String warning);

    List <Healthdaily> AllWarning(@Param("warning")String warning);

    void  deleWarning(@Param("id")int id);

    List<Healthdaily> UserWarning(@Param("number") String number);
}
