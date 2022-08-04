package com.ea.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    ResourceBundleMessageSource messageSource;

//    @GetMapping(path = "/hello")
//    public String getHello(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
//        return messageSource.getMessage("good.morning.message", null, locale);
//    }

    /**
     *  Simplified of above method
     *  Need to change in postman headers
     *  Key = Accept-Language
     *  Value = fr (For French) from messaages_fr.properties
     */
    @GetMapping(path = "/hello")
    public String getHello() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping(path = "/hello/{name}")
    public String getHello(@PathVariable String name) {
        return "Hello "+name;
    }
}
