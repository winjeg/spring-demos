package com.winjeg.demo.spring.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author winjeg
 */
@RestController
@RequestMapping("/")
public class DemoController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }


}
