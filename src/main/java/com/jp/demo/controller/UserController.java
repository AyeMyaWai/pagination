package com.jp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.demo.service.UserService;
import java.util.*;

import com.example.assign.entity.Expense;
import com.jp.demo.entity.User;
import com.jp.demo.form.UserForm;
@Controller
@RequestMapping("/users")

public class UserController {
	@Autowired
	private UserService service;
	
	
	@GetMapping("/list")
	public String getUserList(Model model) {
       List<UserForm> userList =  service.getList();
        model.addAttribute("employees", userList);
        userList.forEach(data->{
        	System.out.print(data.getAge());
        });
       // System.out.println(userList);
        //return "sdf";
       return "users/list";
    } 
	
	 //top→[詳細]押下　select１件
    @GetMapping("details/id={id}")
    public String details(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", service.getUserOne(id));
        return "users/details";
    }

    

  //top→[変更]押下時にchange.htmlを表示するGET
    @GetMapping("change/id={id}")
    public String change(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", service.getUserOne(id));
        return "users/change";
    }
    @PostMapping("change/id={id}")
    public String update(@ModelAttribute User u, Model model) {
        service.updateOne(u.getId(), u.getName(), u.getAge());
        return "redirect:/users/list";
    }
    @PostMapping("delete/id={id}")
    public String delet(@ModelAttribute User u , Model model) {
    	service.delete(u.getId());
    	return "redirect:/users/list";
    }
    
    @GetMapping("register")
    public String register(Model model,@ModelAttribute User user) {
    	model.addAttribute("users",user);
    	return "users/register";
    }
    @PostMapping("register")
    public String register(@ModelAttribute User user,Model model) {
        service.register(user);
    	return "redirect:/users/list";
    }
}
