package com.injahow.booksManager.bean;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BookType {
    int typeId;
    String typeName;
    String typeDesc;
}
