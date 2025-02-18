package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ZhangX
 * @createDate: 2025/2/13
 * @description:
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer myRetryer() {
        return Retryer.NEVER_RETRY;
//        return new Retryer.Default(100, 1, 3); // NEVER_RETRYER feign默认不重试; 100ms初始间隔，最多重试3次
    }
    @Bean
    public Logger.Level myLoggerLevel() {
        return Logger.Level.FULL; // FULL, NONE, BASIC, HEADERS
    }
}
