/*
 * IPCCP (IPC Container Platform) version 1.0
 * Copyright ⓒ 2018 kt corp. All rights reserved.
 * This is a proprietary software of kt corp, and you may not use this file except in
 * compliance with license agreement with kt corp. Any redistribution or use of this
 * software, with or without modification shall be strictly prohibited without prior written
 * approval of kt corp, and the copyright notice above does not evidence any actual or
 * intended publication of such software.
 */
package com.stone.play.common.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Component
public class CommonUtil {


    /**
     * 파일 저장 1건
     *
     * @param file
     * @param saveLocation
     * @param filename
     */
    @SneakyThrows
    public void storeFile(MultipartFile file, String saveLocation, String filename) {

        if (file.isEmpty()) {
            return;
        }

        File dir = new File(saveLocation);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        Files.copy(file.getInputStream(), Paths.get(saveLocation + filename), StandardCopyOption.REPLACE_EXISTING);

    }

    /**
     * 파일 1건 삭제
     *
     * @param saveLocation
     * @param deleteFilename
     */
    @SneakyThrows
    public void deleteFile(String saveLocation, String deleteFilename) {
        Files.deleteIfExists(Paths.get(saveLocation + deleteFilename));
    }

}
