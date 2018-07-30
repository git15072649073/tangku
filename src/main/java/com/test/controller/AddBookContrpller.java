package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.po.BookInfo;
import com.test.po.BookType;
import com.test.service.BookInfoService;
import com.test.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@SessionAttributes({"bookTypes"})
public class AddBookContrpller implements ServletContextAware {
   private ServletContext servletContext;
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private BookTypeService bookTypeService;
    @Override
    public void setServletContext(ServletContext servletContext) {
       this.servletContext=servletContext;
    }

    @RequestMapping("/deleteids.htm")
    public String deletesBookinfo(String [] bookid){
    bookInfoService.deleteisd(bookid);
        return "forward:querybook.htm";
    }


   @RequestMapping("/queryupdate.htm")
   public ModelAndView queryupdate(Integer id){
       BookInfo bookInfo = bookInfoService.selectByPrimaryKey(id);
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("update");
       modelAndView.addObject("book",bookInfo);
       return modelAndView;
   }
   @RequestMapping("/updateBook.htm")
   public String update(BookInfo bookInfo,ModelMap map){
        bookInfoService.updateByPrimaryKeySelective(bookInfo);
       return "forward:querybook.htm";
   }


    @RequestMapping("/delete.htm")
    public void deletebyid(Integer id,HttpServletResponse response) throws IOException {
        int num = bookInfoService.deleteByPrimaryKey(id);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pwriter = response.getWriter();
        if(num>0){
            pwriter.write("<script type='text/javascript'>alert('删除成功');location.href='querybook.htm'</script>");
        }
        else {
            pwriter.write("<script type='text/javascript'>alert('删除失败');location.href='querybook.htm'</script>");
        }

    }

    @RequestMapping("/edit.htm")
    public  ModelAndView editBookinfo(Integer id){
        BookInfo bookInfo = bookInfoService.selectByPrimaryKey(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("book",bookInfo);
        return modelAndView;
    }


    @RequestMapping("/addbook.htm")
    public void addBook(BookInfo bookInfo, HttpServletResponse response) throws IOException {
        System.out.println(bookInfo);
       int num=  bookInfoService.insert(bookInfo);
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter pwriter = response.getWriter();
        if(num>0){
            pwriter.write("<script type='text/javascript'>alert('新增成功');location.href='querybook.htm'</script>");
        }
        else {
            pwriter.write("<script type='text/javascript'>alert('新增失败');location.href='upload.do'</script>");
        }
    }
    @RequestMapping("/querybook.htm")
    public String queryBook(@RequestParam(value="bookTypeid",required=false,defaultValue="0")Integer bookTypeid,String bookname,@RequestParam(value="borrow",required=false,defaultValue="-1")Integer borrow,@RequestParam(value = "now", required = false, defaultValue = "1")Integer now, ModelMap map){
        System.out.println("进入...."+bookname);
        PageHelper.startPage(now,2);
        List<BookInfo> bookInfos=bookInfoService.queryAll(bookTypeid,bookname,borrow);

        PageInfo<BookInfo> pageInfo=new PageInfo<BookInfo>(bookInfos);
        map.put("pageInfo",pageInfo);
        List<BookType> bookTypes=bookTypeService.selectAllBookType();
        map.put("bookTypes",bookTypes);
        //将条件添加到map 作为回显
        map.put("bookTypeid",bookTypeid);
        map.put("bookname",bookname);
        map.put("borrow",borrow);
        return "index2";
    }
    @RequestMapping("/upload.do")
  @ResponseBody
    public String upload(@RequestParam ("fileImage") CommonsMultipartFile fileImage) {
      // 获取上传图片的位置
        String path = servletContext.getRealPath("/resource/upload/");
      System.out.println("上传的路径为:" + path);
        // 获取文件名称
        String name = fileImage.getOriginalFilename();
       //创建一个File
        File file = new File(path, name);
        //把文件写入到对应位置
        try {
            fileImage.getFileItem().write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取相对完整的路径名称
      String imagepath="resource/upload/"+name;

    //将imagepath转换成json对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imagePath",imagepath);
        //转换成json格式的字符串
        String json=jsonObject.toJSONString();

        return json;
    }

}
