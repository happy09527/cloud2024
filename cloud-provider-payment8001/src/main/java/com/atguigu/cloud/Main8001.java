package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: ZhangX
 * @createDate: 2024/11/25
 * @description:
 */
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")
@EnableDiscoveryClient //开启服务发现客户端注解
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}
