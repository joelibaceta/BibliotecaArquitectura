package main.java.models.service;

import java.util.List;

import main.java.models.entity.User;

public interface IUserService {
	
	public void registerUser(User user);
	public List<User> getUsers();

}
