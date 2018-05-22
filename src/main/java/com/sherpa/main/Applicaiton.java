package com.sherpa.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Applicaiton {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Applicaiton.class, args);
    }
}
