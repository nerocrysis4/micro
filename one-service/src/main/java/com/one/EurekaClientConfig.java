package com.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
@EnableEurekaClient
@EnableSwagger2
public class EurekaClientConfig {

    public static void main(String[] args)  {
        SpringApplication.run(EurekaClientConfig.class, args);
    }

    @LoadBalanced
    @Bean("restTemplate")
    public RestTemplate twoService(){
        return new RestTemplate();
    }
}
