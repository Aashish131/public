package com.portal.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.daos.UserDaos;
import com.portal.models.User;
import com.portal.service.UserService;




@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
   private UserDaos userDao;
	public User validateUser(String email, String password) {
		try {
			System.out.println(userDao.validateUser(email, password));
			 return userDao.validateUser(email, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<User> getAllDeveloper() {
		try {
			 return userDao.getAllDeveloper();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<User> getAllTester() {
		try {
			 return userDao.getAllTester();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

}