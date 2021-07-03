package com.injahow.goodsManager.service;

import com.injahow.goodsManager.bean.Member;


import java.util.List;

public interface MemberService {
    Member getMemberById(int memberId);
    List<Member> listCommentAndUser();
}
