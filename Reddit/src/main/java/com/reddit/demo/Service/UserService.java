package com.reddit.demo.Service;

import com.reddit.demo.Model.Post;
import com.reddit.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(User user);

    User findById(long id);

    List<User> findAllUsers();
}
