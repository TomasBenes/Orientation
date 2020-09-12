package com.reddit.demo.Service;

import com.reddit.demo.Model.Post;
import com.reddit.demo.Repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepo postRepo;

    @Autowired
    public PostServiceImpl (PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> allPosts() {
        return this.postRepo.findAll();
    }
}
