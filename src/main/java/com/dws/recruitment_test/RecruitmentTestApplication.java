package com.dws.recruitment_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RecruitmentTestApplication {

    static void main(String[] args) {
        SpringApplication.run(RecruitmentTestApplication.class, args);
    }

}
