package com.injahow.booksManager.controller;

import com.injahow.booksManager.bean.Book;

import com.injahow.booksManager.bean.ResultVO;
import com.injahow.booksManager.service.BookService;
import com.injahow.booksManager.utils.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/list")
    @ResponseBody
    public ResultVO list() {

        List<Book> books = bookService.listBook(1,5);
        PageHelper pageHelper = new PageHelper();
        System.out.println("list...");


        return new ResultVO(200, "success" ,books);
    }

    @PostMapping("/add") // 同步响应，直接跳转
    @ResponseBody
    public HashMap add(Book book, MultipartFile imgFile) {
        // MultipartFile 获取文件流，属性名保持一致
        //bookService.addBook(book);
        //System.out.println("add...");
        //System.out.println(imgFile.getOriginalFilename());
        //model.addAttribute("book", book);
        return null;
    }

}
