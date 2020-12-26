package com.example.demo.Controller;

import com.example.demo.Repo.TodoRepository;
import com.example.demo.Repo.UserRepository;
import com.example.demo.Service.AppUserDetail;
import com.example.demo.Service.ToDoItemService;
import com.example.demo.models.Todo;
import com.example.demo.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ToDoItemService toDoItemService;

    @GetMapping("/newTodo")
    public String newTodo(Model model, @AuthenticationPrincipal AppUserDetail principal){
        UserModel userModel = userRepository.findById(principal.getUserId()).get();
        Todo todo = new Todo();
        todo.setTodoUserModel(userModel);
        model.addAttribute("todo",todo);
        return "User/newTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute("todo") Todo todo,@AuthenticationPrincipal AppUserDetail principal){
        toDoItemService.addTodo(todo);
        return "redirect:/User/index";
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
        todoRepository.deleteById(id);
        return "redirect:/User/index";
    }

    @GetMapping("/updateTodo/{id}")
    public String updateTodo(Model model,@PathVariable("id")int id){
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "User/updateTodo";
    }


}

