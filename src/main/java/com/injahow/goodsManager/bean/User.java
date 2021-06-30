package com.injahow.goodsManager.bean;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {
    int userId;
    String userName;
    String userAvatar;
    String introduction;
    String userTel;
    String userAddress;
    int userRank;
    Date userCreateTime;

}
