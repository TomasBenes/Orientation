package com.databaseintegration.listingtodos.Controllers;

import com.databaseintegration.listingtodos.Model.Todo;
import com.databaseintegration.listingtodos.Repositories.TodoRepo;
import com.databaseintegration.listingtodos.Service.TodoService;
import com.databaseintegration.listingtodos.Service.TodoServiceImpl;
import com.sun.jmx.snmp.SnmpOidTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;
    private final TodoRepo todoRepo;

    public TodoController (TodoRepo todoRepo, TodoService todoService) {
        this.todoRepo = todoRepo;
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false) boolean isActive){
        if (isActive) {
        model.addAttribute("todos", this.todoService.isActive());} else {
            model.addAttribute("todos", this.todoRepo.findAll()); }
        return "index";
    }

    @GetMapping("/add")
    public String addTodo (){
        return "addTodo";
    }

    @PostMapping("/add")
    public String postTodo (@RequestParam String title){
        this.todoRepo.save(new Todo(title));
        return "redirect:/todo/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo (@PathVariable (name = "id") long id){
        this.todoRepo.deleteById(id);
        return "redirect:/todo/list";
    }

    @GetMapping("/edit/{id}")
    public String editTodo (@PathVariable (name = "id") long id, Model model){
        model.addAttribute("todo",this.todoRepo.getOne(id));
        return "editTodo";
    }

    @PostMapping("/edit/{id}")
    public String postEditTodo (@PathVariable (name = "id") long id, @ModelAttribute Todo todo){
        this.todoRepo.findById(todo.getId());
        this.todoRepo.save(todo);
        return "redirect:/todo/list";
    }

}
