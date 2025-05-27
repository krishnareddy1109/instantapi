package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.application.config.EnvLoader;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com.application") // 🟢 Scan all your classes
@EnableMongoRepositories(basePackages = "com.application.repository") // 🟢 MUST match UserRepository package
public class InstantApiApplication {
    public static void main(String[] args) {
    	new EnvLoader(); // Loads .env into system props
        SpringApplication.run(InstantApiApplication.class, args);
    }
}
