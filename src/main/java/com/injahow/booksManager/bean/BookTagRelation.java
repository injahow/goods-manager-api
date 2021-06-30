package com.injahow.booksManager.bean;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BookTagRelation {
    int bookId;
    List<String> tagName;

}
