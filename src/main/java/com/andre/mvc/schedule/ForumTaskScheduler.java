package com.andre.mvc.schedule;

import com.andre.mvc.manager.ForumManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Khemrayev A.K. on 20.05.2015.
 */

@Component
@PropertySource("classpath:application.properties")
public class ForumTaskScheduler {

    @Autowired
    private ForumManager manager;

    private static Set<Task> queue = new LinkedHashSet<Task>();

    @Scheduled(fixedRate = 600000) // 10 min
    public void executeDelayedTasks() {
        try {
            // only for testing status connection with db
            Connection connection = DriverManager.getConnection("db2.url", "db2.username", "db2.password");
            connection.close();
        } catch (SQLException e) {
            return;
        }
        if(!queue.isEmpty()) {
            try {
                Iterator<Task> iterator = queue.iterator();
                while (iterator.hasNext()) {
                    Task task = iterator.next();
                    task.getMethod().invoke(manager, task.getArgument());
                    iterator.remove();
                }
            } catch (ReflectiveOperationException cantHappen) { System.err.println(cantHappen); }
        }
    }

    public ForumManager getManager() {
        return manager;
    }

    public void setManager(ForumManager manager) {
        this.manager = manager;
    }

    public static void addTask(Task task) {
        queue.add(task);
    }
}
