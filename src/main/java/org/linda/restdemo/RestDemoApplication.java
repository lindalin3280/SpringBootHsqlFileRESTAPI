package org.linda.restdemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoApplication {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(RestDemoApplication.class, args);
    }
    
}