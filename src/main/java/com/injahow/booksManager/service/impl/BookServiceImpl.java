package com.injahow.booksManager.service.impl;

import com.injahow.booksManager.bean.Book;
import com.injahow.booksManager.dao.BookDAO;
import com.injahow.booksManager.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookDAO bookDAO;

    @Transactional
    public boolean addBook(Book book) {
        int res = bookDAO.insertBook(book);
        return res>0;
    }

    @Override
    public List<Book> listBook(int start, int pageSize) {
        return bookDAO.listBook(start, pageSize);
    }

    @Override
    public boolean removeBook() {
        return false;
    }

}
