package com.bz.springcloud.controller;


import com.bz.springcloud.bean.Dept;
import com.bz.springcloud.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;

    /**
     * 用于获取注册到Eureka的服务工具
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping(value = "/getById/{id}")
    public Dept queryById(@PathVariable long id) {
        return deptService.queryById(id);
    }

    @GetMapping(value = "/list")
    public List<Dept> queryAll() {
        List<Dept> depts = deptService.queryAll();
        return deptService.queryAll();
    }

    /**
     * 获取注册到Eureka服务
     */
    @GetMapping(value = "/getDiscovery")
    public Object getDiscovery() {
        //获取注册到eureka的服务列表
        List<String> services = discoveryClient.getServices();
        System.out.println("servicesList ==> " + services);

        //得到一个具体的服务信息，通过具体的服务id，applicationName
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() +"\t"+
                    instance.getPort() +"\t"+
                    instance.getUri() +"\t"+
                    instance.getServiceId()
            );
        }
        return this.discoveryClient;
    }
}
