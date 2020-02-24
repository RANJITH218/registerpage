package com.cg.go.service;

import java.util.List;

import com.cg.go.Exception.UserException;
import com.cg.go.bean.User;
import com.cg.go.dao.UserDao;
import com.cg.go.dao.UserDaoMapImpl;

public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	public UserServiceImpl()
	{
		userDao = new UserDaoMapImpl();
	}

	@Override
	public boolean  validateUserName(String username) {
	//boolean flag=false;
	  boolean	flag=username.matches("[a-zA-Z0-9]+");
	 
		return flag;
	}

	@Override  
	public boolean validatePassWord(String passWord) {
	//boolean flag=false;
		//System.out.println(passWord);
	boolean	flag=passWord.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");//[a-zA-Z0-9].*[@#!].{8,15}");
		
		return flag;
	}

	@Override
  public boolean validateReenterPassword(String reenterPassword) 
	{
     boolean flag=reenterPassword.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
		
		return flag;
	}	
    
	@Override
	public boolean validateEMail(String eMail) {
		//boolean flag=false;
		boolean flag=eMail.matches("^([1-zA-Z0-1@.\\s]{1,255})$");//"[a-zA-Z0-9]+(_a-zA-Z0-9+)*@[A-Za-z0-9+)*(.[A-Za-z])");
		return flag;
	}

	@Override
	public boolean validatePhoneNumber(String phoneNumber) {
	boolean	flag=false;
	flag=phoneNumber.matches("[0-9]{10}+");
		return flag;
	}

	@Override
	public void register(User user) throws UserException 
	{
		String userName=user.getUserName();
		boolean flag1=validateUserName(userName);
		if(!flag1)
		{
			throw new UserException("User name should contain alphabets and numbers");
		}
		
	
		String passWord=user.getPassWord();
		
		boolean flag2=validatePassWord(passWord);
		if(!flag2)
		{
			throw new UserException("password should contain atleast one uppercase character, lowercase character, one digit, and one special character");
		}
		
		
      String reenterpassword=user.getReenterPassword();
       boolean flag5=validateReenterPassword(reenterpassword);
		if(user.getPassWord()!=reenterpassword)
		{
	     throw new UserException("password  not matched");
		}
		
		
		
		
		String phoneNumber=user.getPhoneNum();
		boolean flag3=validatePhoneNumber(phoneNumber);
		if(!flag3)
		{
			throw new UserException("Phone number should contain 10 digits");
		}
		String emailId=user.getEmail();
		boolean flag4=validateEMail(emailId);
		if(!flag4)
		{
			throw new UserException("email id should be in correct format");
		}
		userDao.register(user);
	}

	@Override
	public boolean  login(String str1, String str2) throws UserException 
	{ 
		boolean flag1=validateUserName(str1);
		if(!flag1)
		{
			throw new UserException("User name should contain alphabets and numbers");
		}
		
		boolean flag2=validatePassWord(str2);
		if(!flag2)
		{
			throw new UserException("password should contain atleast one uppercase character, lowercase character, one digit, and one special character");
		}
	
		return userDao.login(str1, str2);
	}

	@Override
	public boolean logout(String str) throws UserException
	{
		boolean flag1=validateUserName(str);
		if(!flag1)
		{
			throw new UserException("User name should contain alphabets and numbers");
		}

		return userDao.logout(str);
	}

	@Override
	public List<User> ViewAllUsers() throws UserException {
		
		return userDao.ViewAllUsers();
	}

	
	

}
