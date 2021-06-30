package com.injahow.booksManager.dao;

import com.injahow.booksManager.bean.Book;

import java.util.List;

public interface BookDAO {
    int insertBook(Book book);
    int deleteBookById(int id);
    Book queryBookById(int id);
    List<Book> listBook(int start, int limit);

}
