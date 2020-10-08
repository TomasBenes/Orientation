package com.api.backend.Controller;

import com.api.backend.Model.*;
import com.api.backend.Model.Error;
import com.api.backend.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String homePage () {
        return "index";
    }

    @ResponseBody
    @GetMapping("/doubling")
    public Object doubling (@RequestParam(required = false) Integer input) {
        if (input == null) {
            return new Error ("Please provide an input!");
        } else {
            return new Doubling(input);
        }
    }

    @GetMapping("/greeter")
    @ResponseBody
    public Object greeter(@RequestParam(required = false) String name, @RequestParam(required = false) String title) {
        if (name == null && title == null) {
            return ResponseEntity.badRequest()
                    .body(new Error("Please provide a name and a title!"));
        } else if (name == null) {
            return ResponseEntity.badRequest()
                    .body(new Error("Please provide a name!"));
        } else if (title == null) {
            return ResponseEntity.badRequest()
                    .body(new Error("Please provide a title!"));
        } else {
            return new Greeter(name, title);
        }
    }

    @ResponseBody
    @GetMapping("/appenda/{appendable}")
    public Object append (@PathVariable(required = false) String appendable) {
        if (appendable == null) {
            return ResponseEntity.notFound();
        } else {
            return new Append(appendable);
        }
    }

    @PostMapping("/dountil/{action}")
    @ResponseBody
    public Object addNumber(@PathVariable String action, @RequestBody(required = false) Until until) {
        if (until == null) {
            return ResponseEntity.badRequest()
                    .body(new Error("Please provide a number!"));
        } else {
            return this.mainService.countUntil(until.getUntil(), action);
        }
    }

}
