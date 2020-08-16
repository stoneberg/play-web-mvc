package com.stone.play.crop.controller;

import com.stone.play.common.utils.CommonUtil;
import com.stone.play.crop.payload.CropFileDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/crop")
public class CropController {

    private final CommonUtil commonUtil;

    @Value("${app.file.location}")
    private String fileLocation;

    @GetMapping
    public ModelAndView video(ModelAndView mav) {
        mav.setViewName("pages/crop/crop");
        return mav;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveRoute(@ModelAttribute final CropFileDto cropFileDto) {
        log.info("@crop/upload===========================>{}", cropFileDto);
        log.info("@crop/upload===========================>{}", cropFileDto.getFile());
        log.info("@crop/upload===========================>{}", cropFileDto.getUserId());
        log.info("@crop/upload===========================>{}", cropFileDto.getFilename());
        commonUtil.storeFile(cropFileDto.getFile(), fileLocation, cropFileDto.getFilename());
        // sampleService.saveRoute(route);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
