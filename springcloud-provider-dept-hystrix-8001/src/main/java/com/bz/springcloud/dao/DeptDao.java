package com.bz.springcloud.dao;

import com.bz.springcloud.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept queryById(long id);

    List<Dept> queryAll();
}
