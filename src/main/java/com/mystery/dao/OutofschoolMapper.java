package com.mystery.dao;

import com.mystery.entity.Outofschool;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutofschoolMapper {

    List<Outofschool> getall(String number);
}
