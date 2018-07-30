package com.test.serviceimp;

import com.test.dao.BookTypeMapper;
import com.test.po.BookType;
import com.test.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class BookTypeServiceimpl implements BookTypeService {
    @Autowired
    private BookTypeMapper bookTypeMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bookTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BookType record) {
        return bookTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(BookType record) {
        return bookTypeMapper.insertSelective(record);
    }

    @Override
    public BookType selectByPrimaryKey(Integer id) {
        return bookTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BookType record) {
        return bookTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BookType record) {
        return bookTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BookType> selectAllBookType() {
        return bookTypeMapper.selectAllBookType();
    }
}
