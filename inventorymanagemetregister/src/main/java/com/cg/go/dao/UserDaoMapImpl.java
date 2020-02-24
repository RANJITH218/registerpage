package com.cg.go.dao;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cg.go.Exception.UserException;
import com.cg.go.bean.User;

public class UserDaoMapImpl implements UserDao
{
	private Map<String, User> map;
	//User user=null;
	User user;
	public UserDaoMapImpl()
	{
		map=new HashMap<String, User>();
	}
	@Override
	public void register(User user) throws UserException {

	if(!map.containsKey(user.getUserName()))
	{
		if(user.getPassWord()!=user.getReenterPassword())
			{
		   	throw new UserException("Password not matched");
			}

		map.put(user.getUserName(), user);
		
	}

	
		throw new UserException(" Id already exists");
	
	
	}
	@Override
	public boolean login(String str1, String str2) throws UserException 
	{
		if(map.containsKey(str1))
		{
			User user=map.get(str1);
			if(user.isStatus()==true)
			{
				throw new UserException("You are already logged in");
			}
			if(user.getPassWord().equals(str2))
			{		
		    user.setStatus(true);
			}
			return true;
		}
		
		else
		{
			throw new UserException(" You have not registerd");
		}
		
//			return map.containsKey(str1);
		
     }
	@Override
	public boolean logout(String str) throws UserException {
	boolean status=false;
		if(!map.containsKey(str))
		{
			throw new UserException("You are not logged in");
		}
			User user=map.get(str);
		boolean flag=user.isStatus();
		  if(flag==true)
		  {
			  status=false;
		  }	
		
		return status;
	}
	@Override
	public List<User> ViewAllUsers() throws UserException {
		Collection<User> col=map.values();
		List<User> list=new ArrayList<>();
		for(User u:col)
		{
			list.add(u);
		}
		return list;
	}
	

}
