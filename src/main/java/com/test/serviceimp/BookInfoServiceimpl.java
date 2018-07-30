package com.test.serviceimp;

import com.test.dao.BookInfoMapper;
import com.test.po.BookInfo;
import com.test.po.BookType;
import com.test.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookInfoServiceimpl  implements BookInfoService {
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer bookId) {
        return bookInfoMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public int insert(BookInfo record) {
        return bookInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(BookInfo record) {
        return bookInfoMapper.insertSelective(record);
    }

    @Override
    public BookInfo selectByPrimaryKey(Integer bookId) {
        return bookInfoMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKeySelective(BookInfo record) {
        return bookInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BookInfo record) {
        return bookInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BookInfo> queryAll(Integer bookTypeid, String bookname, Integer borrow) {
        return bookInfoMapper.selectAll(bookTypeid,bookname,borrow);
    }

    @Override
    public int deleteisd(String[] ids) {
        return bookInfoMapper.deleteisd(ids);
    }


}
