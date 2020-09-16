package com.reddit.demo.Service;

import com.reddit.demo.Model.User;
import com.reddit.demo.Repository.PostRepo;
import com.reddit.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void addUser(User user) {
        this.userRepo.save(user);
    }

    @Override
    public User findById(long id) {
        return this.userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepo.findAll();
    }
}
