package com.example.pickitup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/pickitup/main/*")
public class MainController {


    // 메인페이지
    @GetMapping("/main")
    public void main(){
        log.info("============== main페이지");
    }


}
