package com.andre.mvc.manager;

import com.andre.mvc.database.forum.entity.Member;
import com.andre.mvc.database.forum.entity.MemberGroup;
import com.andre.mvc.database.forum.repository.MemberGroupRepository;
import com.andre.mvc.database.forum.repository.MemberRepository;
import com.andre.mvc.schedule.ForumTaskScheduler;
import com.andre.mvc.schedule.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Khemrayev A.K. on 18.05.2015.
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

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/andretest", "root", "password");

            memberRepository.save(member);

            connection.close();
        } catch (SQLException e) {
            Task task = new Task();
            task.setArgument(member);
            ForumTaskScheduler.addTask(task);
            try {
                task.setMethod(ForumManagerImpl.class.getMethod("save", Member.class));
            } catch (NoSuchMethodException cantHappen) {}
        }
    }
}
