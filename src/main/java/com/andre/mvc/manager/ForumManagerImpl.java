package com.andre.mvc.manager;

import com.andre.mvc.database.forum.entity.Member;
import com.andre.mvc.database.forum.entity.MemberGroup;
import com.andre.mvc.database.forum.repository.MemberGroupRepository;
import com.andre.mvc.database.forum.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 1 on 18.05.2015.
 */

@Component("forumManager")
public class ForumManagerImpl implements ForumManager {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberGroupRepository memberGroupRepository;

    @Override
    public Member loadByName(String name) {
        return memberRepository.findByName(name);
    }

    @Override
    public MemberGroup loadByGroupName(String name) {
        return memberGroupRepository.findByName(name);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }
}
