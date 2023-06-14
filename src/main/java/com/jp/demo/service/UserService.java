package com.jp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.demo.repository.UserMapper;
import java.util.*;
import com.jp.demo.entity.User;
import com.jp.demo.form.UserForm;
@Service
public class UserService {
	@Autowired
    UserMapper mapper;
	
	  //select全件
   
    public List<UserForm> getList(){
    	   System.out.println("sdfdsf");
    	return mapper.find();
    }
    //select１件
    public User getUserOne(int id) {
        return  mapper.findOne(id);
    }
    
  //update
    public void updateOne(int id, String name, int age) {
        mapper.updateOne(id, name, age);
    }
    
    //delete
    public void delete(int id) {
    	mapper.deleteOne(id);
    }
    
    //register
    public void register(User user) {
    	mapper.register(user);
    }
}
