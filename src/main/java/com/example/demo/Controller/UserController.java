package com.example.demo.Controller;

import com.example.demo.Repo.TodoRepository;
import com.example.demo.Service.AppUserDetail;
import com.example.demo.Service.ToDoItemService;
import com.example.demo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private ToDoItemService toDoItemService;

    @Autowired
    private TodoRepository todoRepository;




    //Display List of Todo_Items

    @GetMapping("index")
    public String index(@AuthenticationPrincipal AppUserDetail principal, Model model){
        List<Todo> todoList = new ArrayList<Todo>();
        if(principal.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
           todoList = todoRepository.findByTodoUserModelUserId(principal.getUserId());
        }
        else{
            todoList = todoRepository.findAll();
        }
        model.addAttribute("todoList",todoList);
        return "User/index";
    }

}
