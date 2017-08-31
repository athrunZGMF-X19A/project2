package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.UserBean;
import com.revature.daos.UserDAO;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO dao;

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	@RequestMapping(value="user/createUser", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createUser(@Valid @RequestBody UserBean user){
		dao.createUser(user);
	}
	
	@RequestMapping(value="user/updateUser", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateUser(@RequestBody UserBean user){
		dao.updateUser(user);
	}
	@RequestMapping(value="user/getUsers", method=RequestMethod.GET, 
			/*consumes=MediaType.APPLICATION_JSON_VALUE,*/ produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserBean> getUsers(){
		return dao.getUsers();
	}
	@RequestMapping(value="user/deleteUser", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteUser(@RequestBody UserBean user){
		dao.deleteUser(user);
	}
	
	
	
}
