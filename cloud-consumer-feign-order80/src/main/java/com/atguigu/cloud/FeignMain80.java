package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: ZhangX
 * @createDate: 2024/12/9
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启openFeign功能
public class FeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignMain80.class, args);
    }
}
