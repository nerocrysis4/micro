package com.two.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/two")
public class TwoController {

    @GetMapping
    public ResponseEntity<String> fetchHello() {
        return new ResponseEntity("Hello", HttpStatus.OK);
    }

}
