package com.sendtk.app.models.dao;

import com.sendtk.app.models.User;

public interface UserDAO {
	
	 public User findByUserName(String username);
	 
	 
}
