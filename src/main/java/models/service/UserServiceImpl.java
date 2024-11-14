package main.java.models.service;

import java.util.Collections;
import java.util.List;

import main.java.models.entity.User;
import main.java.models.localdata.UserLocalData;

public class UserServiceImpl implements IUserService{
	
	UserLocalData userLocalData;
	
	UserServiceImpl( UserLocalData userLocalData ){
		this.userLocalData = userLocalData;
	}

	@Override
	public void registerUser(User user) {
		
		if (!this.userLocalData.getUsers().contains(user)) {
			this.userLocalData.getUsers().add(user);
      }
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsers() {
		return Collections.unmodifiableList(this.userLocalData.getUsers());
	}

}
