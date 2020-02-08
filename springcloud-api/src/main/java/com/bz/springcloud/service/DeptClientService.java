package com.bz.springcloud.service;

import com.bz.springcloud.bean.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    @PostMapping("/dept/add")
    boolean addDept(Dept dept);

    @GetMapping("/dept/getById/{id}")
    Dept queryById(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    List<Dept> queryAll();
}
