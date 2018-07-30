package com.test.controller;

import com.test.po.BookInfo;
import com.test.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    private BookInfoService bookInfoService;
    @RequestMapping("/login.do")
    public String login(String username, String password, ModelMap map){
        map.put("username",username);
        map.put("password",password);
        BookInfo bookInfo = bookInfoService.selectByPrimaryKey(2);
        map.put("bookInfo",bookInfo);
       return "forward:index.do";

    }
}
