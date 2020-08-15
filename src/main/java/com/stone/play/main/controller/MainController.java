package com.stone.play.main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping(value = {"/", "/main"})
    public ModelAndView main(ModelAndView mav) {
        mav.addObject("greeting", "Hello World!");
        mav.setViewName("pages/main/main");
        return mav;
    }
}
