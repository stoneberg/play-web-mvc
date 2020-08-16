package com.stone.play.video.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/video")
public class VideoController {

    @GetMapping
    public ModelAndView video(ModelAndView mav) {
        mav.setViewName("pages/video/video");
        return mav;
    }
}
