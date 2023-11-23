package com.one.controller;

import com.one.modal.NameInput;
import com.one.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/one")
public class OneController {

    private static final Logger log = LoggerFactory.getLogger(OneController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUser() {
        log.info("called service status");
        return "UP";
    }

    @PostMapping
    public String createMessage(@RequestBody NameInput msg) {
        return userService.createMessage(msg);
    }
}
