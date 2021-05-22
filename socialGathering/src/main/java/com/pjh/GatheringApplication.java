package com.pjh;

import com.socialContact.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: GatheringApplicaton
 * @Author: 86151
 * @Date: 2021/5/4 17:35
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.pjh.mapper")
public class GatheringApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
