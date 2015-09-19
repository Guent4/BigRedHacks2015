package com.bigredhacks.hackathon.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.bigredhacks.hackathon")
@Configuration
@EnableJpaRepositories(basePackages = "com.bigredhacks.hackathon")
@EntityScan(basePackages = "com.bigredhacks.hackathon")
public class Application extends WebMvcAutoConfiguration
{

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
