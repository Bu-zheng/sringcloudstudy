package com.bz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //在服务启动后自动注册到服务中心
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker   //添加对熔断的支持
public class DeptHystrixStart_8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptHystrixStart_8001.class);
    }
}
