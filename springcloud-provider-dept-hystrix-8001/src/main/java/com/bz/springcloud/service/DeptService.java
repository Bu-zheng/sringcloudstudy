package com.bz.springcloud.service;

import com.bz.springcloud.bean.Dept;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);

    Dept queryById(long id);

    List<Dept> queryAll();
}
