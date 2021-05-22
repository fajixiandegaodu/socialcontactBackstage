package com.pjh;

import com.socialContact.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: ArticleApplication
 * @Author: 86151
 * @Date: 2021/5/4 19:36
 * @Description: TODO
 */
@SpringBootApplication
@MapperScan("com.pjh.mapper")
@EnableEurekaClient
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class);
    }
    @Bean
    public IdWorker idWorker(){
        return  new IdWorker();
    }
}
