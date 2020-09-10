package com.databaseintegration.listingtodos.Service;

import com.databaseintegration.listingtodos.Model.Todo;
import com.databaseintegration.listingtodos.Repositories.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepo todoRepo;

    @Autowired
    public TodoServiceImpl (TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Override
    public List<Todo> isActive() {
        return this.todoRepo.findAll().stream().filter(todo -> !todo.isDone()).collect(Collectors.toList());
    }
}
