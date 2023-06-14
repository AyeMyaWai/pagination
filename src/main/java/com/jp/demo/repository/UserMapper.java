package com.jp.demo.repository;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.jp.demo.repository.UserMapper;
import com.jp.demo.entity.User;
import com.jp.demo.form.UserForm;

@Mapper
public interface UserMapper {
	
	  //select全件
    public List<UserForm> find();
    
    public User findOne(int id);
    
    //update
    public void updateOne(@Param("id") int id, @Param("name") String name, @Param("age") int age);

     //delete
    public void deleteOne(@Param("id") int id);
    
    public void register(User user);
}
