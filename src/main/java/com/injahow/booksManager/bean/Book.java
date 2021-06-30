package com.injahow.booksManager.bean;


import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Book {
    int id;
    String bookName;
    String bookAuthor;
    Double bookPrice;
    String bookImg;
    String bookSummary;

    String bookType;

    BookTagRelation bookTagRelation;

    String bookISBN;
    Date createTime;
}
