package com.epam.jmp.bolat.tdd.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by dom on 25.02.2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.epam.jmp.bolat.tdd")
@EnableJpaRepositories( "com.epam.jmp.bolat.tdd.dao")
@EntityScan("com.epam.jmp.bolat.tdd.model")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}