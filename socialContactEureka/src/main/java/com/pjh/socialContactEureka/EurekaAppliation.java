package com.pjh.socialContactEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: EurekaAppliation
 * @Author: 86151
 * @Date: 2021/5/7 15:53
 * @Description: TODO
 */
/*声明当前服务是Eureka服务*/
@EnableEurekaServer
/*SpringBoot启动注解*/
@SpringBootApplication
public class EurekaAppliation {
    public static void main(String[] args) {
        SpringApplication.run(EurekaAppliation.class);
    }
}
