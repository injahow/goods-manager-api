package com.injahow.goodsManager.service.impl;

import com.injahow.goodsManager.bean.Member;
import com.injahow.goodsManager.dao.MemberDAO;
import com.injahow.goodsManager.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberDAO memberDAO;

    @Override
    public Member getMemberById(int memberId) {
        return memberDAO.findMemberById(memberId);
    }

    @Override
    public List<Member> listCommentAndUser() {
        return memberDAO.listCommentAndUser();
    }
}
