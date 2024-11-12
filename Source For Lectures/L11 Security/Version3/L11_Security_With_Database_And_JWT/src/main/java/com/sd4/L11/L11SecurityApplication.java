package com.sd4.L11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
@EnableWebSecurity
public class L11SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(L11SecurityApplication.class, args);
    }

}
