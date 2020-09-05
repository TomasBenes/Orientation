package com.databaseintegration.listingtodos.Controllers;

import com.databaseintegration.listingtodos.Model.Todo;
import com.databaseintegration.listingtodos.Repositories.TodoRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepo todoRepo;

    public TodoController (TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }


    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("todos", this.todoRepo.findAll());
        return "index";
    }

}
