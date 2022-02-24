package com.mystery.service;


import com.mystery.entity.College;

import java.util.List;

public interface ICollegeService {
    List<College> CollegeList ();
    void dele(Integer id);
    void save(String name);
}
