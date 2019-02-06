package com.niloy.test.controller;

import com.niloy.test.dao.UsersDAO;
import com.niloy.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    UsersDAO userRepo;
     @GetMapping("/")
    public String home(){
         System.out.println(userRepo.findAll().toString());
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard()
    {
        return "dashboard";
    }

    @GetMapping("/table")
    public String table()
    {
        return "table";
    }

    @GetMapping("/viewstudent")
    public String viewStudent(Model model)
    {
        String obj = "niloy";
        model.addAttribute("obj",obj);
        return "viewstudents";
    }


    @GetMapping("/login")
    public String login(@RequestParam String email,String pass)
    {
        User user = new User();
        user = userRepo.findByEmail(email);
        if(user.getPassword().equals(pass))
        {
            return "dashboard";
        }
        return "index";
    }


}
