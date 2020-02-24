package com.cg.go.test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.go.bean.User;
import com.cg.go.dao.UserDao;
import com.cg.go.dao.UserDaoMapImpl;

class UserTest 

{
	 UserDao dao=null;
     @BeforeEach
     public void setUp()
{
       dao=new UserDaoMapImpl();
}
	
	@Test
	void testregister () throws Exception
	{
		User user=new User();
		user.setUserName("Shara123");
		user.setPhoneNum("1234567890");
		user.setEmail("navya@gmail.com");
		user.setPassWord("Bvrit@123");
		
	 	dao.register(user);
	 	List<User> l = dao.ViewAllUsers();
	 	assertEquals(1,l.size());
	 
	
		
	}
	@Test
   void testlogin()throws Exception{
		

		User user=new User();
		user.setUserName("Shara123");
		
		user.setPassWord("Bvrit@123");
		dao.register(user);
		
	 	boolean g=dao.login("Shara123","Bvrit@123");
	 	
		
		assertTrue(g==true);
		
		
	}
	

}
