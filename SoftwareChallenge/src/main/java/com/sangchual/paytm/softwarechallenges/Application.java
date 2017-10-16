package com.sangchual.paytm.softwarechallenges;

import org.h2.server.web.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args) ;
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext cts) {
        return args -> {
           System.out.println("Let's inspect the beans provided by Spring Boot:");

           String[] beanNames = cts.getBeanDefinitionNames() ;
           Arrays.sort(beanNames) ;
           for(String beanName : beanNames) {
               System.out.println(beanName) ;
           }
        } ;
    }

}