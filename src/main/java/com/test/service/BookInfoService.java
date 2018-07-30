package com.test.service;

import com.test.po.BookInfo;
import com.test.po.BookType;

import java.awt.print.Book;
import java.util.List;

public interface BookInfoService {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    List<BookInfo>  queryAll(Integer bookTypeid, String  bookname, Integer borrow);

    int deleteisd(String[] ids);
}
