package com.bz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ribbon跟Eureka整合以后，客户端可以直接调用，不用关系ip地址跟端口号。
 */
@SpringBootApplication
@EnableEurekaClient     //向Eureka注冊自己
@EnableFeignClients(basePackages = {"com.bz.springcloud"})
//@ComponentScan(value = "com.bz.springcloud")
public class FeignConsumerDeptStart {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerDeptStart.class);
    }
}
