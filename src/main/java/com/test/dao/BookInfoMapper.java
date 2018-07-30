package com.test.dao;

import com.test.po.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    List<BookInfo>  selectAll(@Param("id") Integer bookTypeid,@Param("bookname") String bookname,@Param("borrow") Integer borrow);

     int deleteisd(String[] ids);

}