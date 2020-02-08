package com.bz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动之后访问下端口看是否启动
@SpringBootApplication
@EnableEurekaServer     //服务端启动类，接收别人注册进来
public class EurekaStart_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaStart_7003.class);
    }
}
