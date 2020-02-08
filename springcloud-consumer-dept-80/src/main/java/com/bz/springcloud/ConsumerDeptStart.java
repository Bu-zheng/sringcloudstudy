package com.bz.springcloud;

import com.bz.myrule.BzRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * ribbon跟Eureka整合以后，客户端可以直接调用，不用关系ip地址跟端口号。
 */
@SpringBootApplication
@EnableEurekaClient     //向Eureka注冊自己
//在微服务启动的时候，就能去加载我们自定义的Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = BzRule.class)
public class ConsumerDeptStart {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerDeptStart.class);
    }
}
