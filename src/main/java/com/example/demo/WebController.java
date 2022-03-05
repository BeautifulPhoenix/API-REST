package com.example.demo;

import java.text.Normalizer.Form;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/myLibrary")
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(Author author) {
        return "Form";

    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid Author author, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";

        }

        return "redirect:/results";

    }

    // Web Service
    @RequestMapping("/web")
    public String getWeb() {
        System.out.println("Controller Web Request");

        return "web.html";
    }

}
