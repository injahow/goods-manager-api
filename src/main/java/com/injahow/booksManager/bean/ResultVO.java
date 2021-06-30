package com.injahow.booksManager.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {

    private Integer code;
    private String message;
    private T data;

}
