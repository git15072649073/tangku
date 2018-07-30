package com.test.controller;

import com.test.po.BookType;
import com.test.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BookTypeService bookTypeService;
    @RequestMapping("index.do")
    public String index(){
//        return "index";
        return "index2";
    }
    @RequestMapping("/toadd.do")
    public String toadd(ModelMap map){
        //准备书籍类型
        List<BookType> bookTypes = bookTypeService.selectAllBookType();
//        System.out.println(bookTypes.size());
        map.put("bookTypes",bookTypes);
        return "add";
    }
}
