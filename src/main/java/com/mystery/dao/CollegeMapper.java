package com.mystery.dao;

import com.mystery.entity.College;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeMapper {
  List<College> CollegeList();
  void dele(Integer id);
  void save(String name);
}
