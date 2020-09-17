package com.reddit.demo.Controller;

import com.reddit.demo.Model.Post;
import com.reddit.demo.Repository.PostRepo;
import com.reddit.demo.Service.PostService;
import com.reddit.demo.Service.PostServiceImpl;
import com.reddit.demo.Service.UserService;
import com.reddit.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;


    public PostController (PostService postService, UserService userService){
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String list(Model model, @RequestParam String username){
            model.addAttribute("user",this.userService.findByUsername(username));
            model.addAttribute("posts", this.postService.allPosts());
        return "index";
    }

    @PostMapping("/like/{id}")
    public String plusNewVotes(@PathVariable long id){
        this.postService.plusVote(id);
        return "redirect:/";
    }

    @PostMapping("/dislike/{id}")
    public String minusNewVotes(@PathVariable long id){
        this.postService.minusVote(id);
        return "redirect:/";
    }

    @GetMapping("/submit/{username}")
    public String submit (@PathVariable String username, Model model) {
        this.userService.findByUsername(username);
        model.addAttribute("user",this.userService.findByUsername(username));
        return "submit";
    }

    @PostMapping("/submit/")
    public String addPost (@RequestParam String username, @ModelAttribute Post post){
        /*this.userService.findByUsername(username).getUserPosts().add(post);*/
        post.setUser(this.userService.findByUsername(username));
        this.postService.addPost(post);
        return "redirect:/" + "?username=" + username;
    }


}
