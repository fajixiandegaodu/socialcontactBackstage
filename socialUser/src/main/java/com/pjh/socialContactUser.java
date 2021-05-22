package com.pjh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: socialContactUser
 * @Author: 86151
 * @Date: 2021/5/8 13:51
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.pjh.mapper")
public class socialContactUser {
    public static void main(String[] args) {
        SpringApplication.run(socialContactUser.class);
    }
}
