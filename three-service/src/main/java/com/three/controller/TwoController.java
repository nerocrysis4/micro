package com.three.controller;

import com.three.modal.NameInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/three")
public class TwoController {

    @PostMapping
    public ResponseEntity<String> getLog(@RequestBody NameInput msg) {
        return new ResponseEntity(msg.getName() + " " + msg.getSurName(), HttpStatus.OK);
    }

}
