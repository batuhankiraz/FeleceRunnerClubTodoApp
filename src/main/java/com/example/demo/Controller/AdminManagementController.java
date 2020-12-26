package com.example.demo.Controller;

import com.example.demo.Repo.UserRepository;
import com.example.demo.Service.AppUserDetail;
import com.example.demo.Service.AppUserDetailService;
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
public class AdminManagementController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppUserDetailService appUserDetailService;

    @GetMapping("/newUser")
    public String newUser(Model model){
        UserModel user = new UserModel();
        model.addAttribute("user",user);
        return "Admin/newUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") UserModel user,@AuthenticationPrincipal AppUserDetail principal){
        appUserDetailService.addUser(user);
        return "redirect:/Admin/index";
    }


    @GetMapping(path = "/deleteUser/{userId}")
    public String delete(@PathVariable("userId") int userId){
        userRepository.deleteById(userId);
        return "redirect:/Admin/index";
    }

}
