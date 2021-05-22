package com.socialContact;

import com.socialContact.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @ClassName: BaseApplication
 * @Author: 86151
 * @Date: 2021/4/21 18:54
 * @Description: TODO
 */
@SpringBootApplication
/*扫描实体类*/
@MapperScan("com.socialContact.Dao")
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }
    /*ID生成器*/
    @Bean
    public IdWorker getIdWorker(){
        return new IdWorker(1,1);
    }

}
