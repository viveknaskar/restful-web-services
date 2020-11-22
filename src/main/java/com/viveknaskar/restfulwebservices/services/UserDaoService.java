package com.viveknaskar.restfulwebservices.services;

import com.viveknaskar.restfulwebservices.beans.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();

    private static int userCount = 4;

    static {
        userList.add(new User(1, "Bruce Wayne", new Date()));
        userList.add(new User(2, "Tony Stark", new Date()));
        userList.add(new User(3, "Clark Kent", new Date()));
        userList.add(new User(4, "Steve Rogers", new Date()));
    }

    public List<User> findAll() {
        return userList;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        userList.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user: userList) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }



}
