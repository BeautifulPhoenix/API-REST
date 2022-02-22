package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/myLibrary")
public class WebController {

    @RequestMapping("/web")
    public String getWeb() {
        System.out.println("Controller Web Request");

        return "web.html";
    }

}
