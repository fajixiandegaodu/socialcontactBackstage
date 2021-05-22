package com.socialContact.QA;

import com.socialContact.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: QAApplication
 * @Author: 86151
 * @Date: 2021/4/25 14:21
 * @Description: TODO
 */
@SpringBootApplication
/*扫描Mapper类所在的包*/
@MapperScan("com.socialContact.QA.socialContactQA.mapper")
public class QAApplication {
    public static void main(String[] args) {
        SpringApplication.run(QAApplication.class);
    }
    @Bean
    public IdWorker getIdWorker(){
        return new IdWorker();
    }
}
