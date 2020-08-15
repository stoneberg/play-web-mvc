package com.stone.play.crop;

import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;
import java.io.*;

public class Base64StringToImageTest {


    @Test
    void runConvertTest() throws FileNotFoundException {

        String base64String = "";
        String[] strings = base64String.split(",");
        String extension;
        switch (strings[0]) {//check image's extension
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default://should write cases for more images types
                extension = "jpg";
                break;
        }
        //convert base64 string to binary data
        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
        //String path = "C:\\Users\\stone\\Desktop\\test_image." + extension;
        String path = "D:\\etc\\upload\\test_image." + extension;
        File file = new File(path);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
