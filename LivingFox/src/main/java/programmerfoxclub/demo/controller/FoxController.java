package programmerfoxclub.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import programmerfoxclub.demo.Model.Fox;
import programmerfoxclub.demo.service.FoxService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class FoxController {

    private final FoxService foxService;

    @Autowired
    public FoxController (FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/nutrition")
    public String getNutritionStore (@RequestParam String name, Model model){
        model.addAttribute("fox", foxService.getFoxByName(name));
        return "nutrition";
    }

    @PostMapping("/nutrition")
    public String postFoodDrink (@RequestParam String food, @RequestParam String drink, @RequestParam String name) {
        String exFood = this.foxService.getFoxByName(name).getFood();
        String exDrink = this.foxService.getFoxByName(name).getDrink();
        this.foxService.getFoxByName(name).setFood(food);
        this.foxService.getFoxByName(name).setDrink(drink);
        this.foxService.getFoxByName(name).addAction(LocalDateTime.now() + " : Food has been changed from: " + exFood + " to: " + food);
        this.foxService.getFoxByName(name).addAction(LocalDateTime.now() + " : Drink has been changed from: " + exDrink + " to: " + drink);
        return "redirect:/" + "?name=" + name;
    }

    @GetMapping("/trickCenter")
    public String getTricks (@RequestParam String name, Model model) {
        model.addAttribute("fox", foxService.getFoxByName(name));
        return "tricks";
    }

    @PostMapping("/trickCenter")
    public String postTricks (@RequestParam String trick, @RequestParam String name) {
        this.foxService.getFoxByName(name).addTrick(trick);
        this.foxService.getFoxByName(name).addAction(LocalDateTime.now() + " : Learned to: " + trick);
        return "redirect:/" + "?name=" + name;
    }

    @GetMapping("/actionHistory")
    public String getActionHistory(@RequestParam String name, Model model) {
        model.addAttribute("fox", foxService.getFoxByName(name));
        model.addAttribute("foxAction", foxService.getFoxByName(name).getActionHistory());
        return "action";
    }
}
