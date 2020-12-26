package com.example.demo.Service;

import com.example.demo.models.Todo;

import java.util.List;

public interface ToDoItemService {

    List<Todo> getAllTodo();

    void addTodo(Todo todo);

}
