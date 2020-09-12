package com.reddit.demo.Controller;

import com.reddit.demo.Model.Post;
import com.reddit.demo.Repository.PostRepo;
import com.reddit.demo.Service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostServiceImpl postService;
    private final PostRepo postRepo;


    public PostController (PostServiceImpl postService, PostRepo postRepo){
        this.postService = postService;
        this.postRepo = postRepo;
    }

    @GetMapping("/")
    public String list(Model model){
            model.addAttribute("posts", this.postService.allPosts());
        return "index";
    }

    @PostMapping("/{id}")
    public String setNewVotes(@PathVariable long id, @ModelAttribute long votes){
        this.postRepo.getOne(id).setVotes(votes);
        return "index";
    }

    @GetMapping("/submit")
    public String submit () {
        return "submit";
    }

    @PostMapping("/submit")
    public String addPost (@ModelAttribute Post post){
        this.postRepo.save(post);
        return "redirect:/";
    }
}
