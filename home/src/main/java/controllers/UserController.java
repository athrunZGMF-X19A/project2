package controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import beans.UserBean;
import daos.UserDAO;

@Controller
@RequestMapping(value="/beans/UserBean")
public class UserController {
	
	@Autowired
	private UserDAO dao;

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	@RequestMapping(value="beans/UserBean/createUser", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createUser(@Valid @RequestBody UserBean user){
		dao.createUser(user);
	}
	
	@RequestMapping(value="beans/UserBean/updateUser", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(UserBean user){
		dao.updateUser(user);
	}
	@RequestMapping(value="beans/UserBean/getUsers", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<UserBean> getUsers(){
		return dao.getUsers();
	}
	@RequestMapping(value="beans/UserBean/deleteUser", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(UserBean	user){
		dao.deleteUser(user);
	}
	
	
	
}
