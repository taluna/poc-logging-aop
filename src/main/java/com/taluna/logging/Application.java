package com.taluna.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.taluna")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
