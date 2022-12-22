package com.winjeg.demo.spring.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author winjeg
 */
@SpringBootApplication
@Slf4j
public class SpringDemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemosApplication.class, args);
        log.info("----------------Spring started................");
    }

}
