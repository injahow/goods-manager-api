package com.injahow.booksManager.service;


import com.injahow.booksManager.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    boolean addBook(Book book);
    List<Book> listBook(@Param("start") int start,
                        @Param("pageSize") int pageSize);

    boolean removeBook();

}
