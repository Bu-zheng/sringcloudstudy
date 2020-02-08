package com.bz.springcloud.controller;

import com.bz.springcloud.bean.Dept;
import com.bz.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {


    @Autowired
    private DeptClientService deptClientService = null;


    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.queryAll();
    }

    @RequestMapping("/consumer/dept/add")
    public Boolean add(@RequestBody Dept dept){
        return deptClientService.addDept(dept);
    }

}
