package com.example.demo.Service;

import com.example.demo.Repo.TodoRepository;
import com.example.demo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImplements implements ToDoItemService {

    @Autowired
    private TodoRepository todoRepository;


    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public void addTodo(Todo todo) {
        this.todoRepository.save(todo);
    }


}
