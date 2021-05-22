package com.pjh.socialContactGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName: socialContactGateWayApplication
 * @Author: 86151
 * @Date: 2021/5/7 18:04
 * @Description: TODO
 */
/*SpringBoot启动注解*/
@SpringBootApplication
/*Eureka客户端注解*/
@EnableEurekaClient
public class socialContactGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(socialContactGateWayApplication.class);
    }
    /*
    * IP限流
    * */

    @Bean(name ="ipKeyResolver")

    public KeyResolver userKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //获取远程客户端IP
                String hostName = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
                System.out.println("hostName:"+hostName);
                return Mono.just(hostName);

            }
        };
    }

}
