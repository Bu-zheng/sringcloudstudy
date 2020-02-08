package com.bz.springcloud.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor  //无参注解
@Accessors(chain = true)  //链式写法    
public class Dept implements Serializable {

    private long dept_no;

    private String dept_name;

    /**
     * 存在哪个数据库的字段~~微服务  一个服务对应一个数据库，同一个信息不可能存在不同数据库
     */
    private String db_source;

    public Dept(String deptName) {
        this.dept_name = deptName;
    }

}