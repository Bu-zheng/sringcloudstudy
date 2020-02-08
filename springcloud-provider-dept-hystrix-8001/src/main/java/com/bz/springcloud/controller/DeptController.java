package com.bz.springcloud.controller;


import com.bz.springcloud.bean.Dept;
import com.bz.springcloud.service.DeptService;
import com.bz.springcloud.service.impl.DeptServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;


    @PostMapping(value = "/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping(value = "/getById/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept queryById(@PathVariable long id) {
        Dept dept = deptService.queryById(id);

        if(null == dept){
            throw new RuntimeException("id=>"+ id + ",不存在该数据，或数据无法找到");
        }
        return dept;
    }

    @GetMapping(value = "/list")
    public List<Dept> queryAll() {
        List<Dept> depts = deptService.queryAll();
        return deptService.queryAll();
    }


    //备用方法
    public Dept hystrixGet(@PathVariable("id") Long id){

        return new Dept()
                .setDept_no(id)
                .setDept_name("id=>"+ id + ",不存在该数据")
                .setDb_source("no this datasource");
    }


}
