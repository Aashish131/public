package com.portal.daos;
	
	import java.util.List;
	
	import com.portal.models.User;
	
	public interface UserDaos {
	
	       public User validateUser(String email,String password); 
	       public List<User> getAllDeveloper();
	       public List<User> getAllTester();
	       public User getUserById(int userId);
	       
	}

