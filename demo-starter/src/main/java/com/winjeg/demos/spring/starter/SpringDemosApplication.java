package com.winjeg.demos.spring.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author winjeg
 */
@Slf4j
@SpringBootApplication
@ServletComponentScan
@ComponentScan("com.winjeg.demos.spring")
public class SpringDemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemosApplication.class, args);
        log.info("----------------Spring started................");
    }

}
