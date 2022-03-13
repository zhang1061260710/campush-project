package com.mystery.dao;

import com.mystery.entity.Outofschool;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutofschoolMapper {

    List<Outofschool> getall(@Param("number") String number);

    void UpdateApproval(@Param("number") String number, @Param("whether") String whether);

    void SaveAdd (Outofschool outofschool);

    void BatchDeleOutoFschool(List<Integer> userIds);
}
