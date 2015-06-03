package com.andre.mvc.manager;

import com.andre.mvc.database.forum.entity.Member;
import com.andre.mvc.database.forum.entity.MemberGroup;

/**
 * Created by Khemrayev A.K. on 18.05.2015.
 */
public interface ForumManager {
    public Member loadByName(String name);

    public MemberGroup loadByGroupName(String name);

    public void save(Member member);
}
