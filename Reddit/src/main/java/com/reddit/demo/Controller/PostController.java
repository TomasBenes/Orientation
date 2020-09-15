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


    public PostController (PostServiceImpl postService){
        this.postService = postService;
    }

    @GetMapping("/")
    public String list(Model model){
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

    @GetMapping("/submit")
    public String submit () {
        return "submit";
    }

    @PostMapping("/submit")
    public String addPost (@ModelAttribute Post post){
        this.postService.addPost(post);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    /*@PostMapping("/login")
    public String postLoginPage(@RequestParam String name){
        Fox fox = new Fox(name, "meat", "milk", new ArrayList<String>());
        this.foxService.addFox(fox);
        return "redirect:/" + "?name=" + name;
    }*/
}
