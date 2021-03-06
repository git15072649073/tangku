package com.test.dao;

import com.test.po.BookType;

import java.util.List;

public interface BookTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);
    //查询所有书籍的类型
    List<BookType> selectAllBookType();
}