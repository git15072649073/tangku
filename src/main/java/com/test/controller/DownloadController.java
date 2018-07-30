package com.test.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class DownloadController {
    @RequestMapping("download.htm")
    public ResponseEntity<byte[]> download() throws IOException {
        String path = "D:\\IDEA\\apache-tomcat-9.0.0.M26\\webapps\\images\\122.png";
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        // String fileName=new
        // String("你好.txt".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", "122.png");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }



}
