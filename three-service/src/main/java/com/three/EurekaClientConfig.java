package com.three;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
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
