package programmerfoxclub.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import programmerfoxclub.demo.Model.Fox;
import programmerfoxclub.demo.service.FoxService;

import java.util.ArrayList;

@Controller
public class MainController {

    private final FoxService foxService;

    @Autowired
    public MainController (FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/")
    public String homePage(@RequestParam String name, Model model){
        model.addAttribute("fox", foxService.getFoxByName(name));
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String postLoginPage(@RequestParam String name){
        Fox fox = new Fox(name, "meat", "milk", new ArrayList<String>());
        this.foxService.addFox(fox);
        return "redirect:/" + "?name=" + name;
    }



}
