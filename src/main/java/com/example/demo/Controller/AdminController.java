package com.example.demo.Controller;


import com.example.demo.Repo.UserRepository;
import com.example.demo.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("index")
    public String index(Model model){
        List<UserModel> userModelList = new ArrayList<>();
        userModelList = userRepository.findAll();
        model.addAttribute("userModelList",userModelList);

        return "Admin/index";
    }


}
