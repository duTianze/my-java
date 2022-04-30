package com.dutianze.base.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dutianze
 * @date 2022/4/30
 */
@RestController
@RequestMapping("/api/ok")
public class OkController {

    @GetMapping
    public String ok() {
        return "ok";
    }
}
