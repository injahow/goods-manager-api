package com.injahow.goodsManager.dao;

import com.injahow.goodsManager.bean.Comment;
import com.injahow.goodsManager.bean.Member;

import java.util.List;

public interface MemberDAO {
    Member findMemberById(int memberId);
    List<Member> listCommentAndUser();
}
