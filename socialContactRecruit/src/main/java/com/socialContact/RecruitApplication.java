package com.socialContact;
import com.socialContact.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: RecruitApplication
 * @Author: 86151
 * @Date: 2021/4/22 19:24
 * @Description: TODO
 */
@SpringBootApplication
/*包扫描注解*/
@MapperScan("com.socialContact.Dao2")
public class RecruitApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class);
    }
    /*ID生成器*/
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
