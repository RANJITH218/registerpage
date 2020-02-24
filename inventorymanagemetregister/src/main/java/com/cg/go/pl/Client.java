package com.cg.go.pl;

import java.util.List;
import java.util.Scanner;

import com.cg.go.bean.User;
import com.cg.go.service.UserService;
import com.cg.go.service.UserServiceImpl;

public class Client {

	public static void main(String[] args) {
		Scanner scr=new Scanner(System.in);
		UserService userService=new UserServiceImpl();
		int choice=0;
		User user=null;
		List<User> list=null;
		while(true)
		{
			System.out.println("1.Register");
			System.out.println("2.Login");
			System.out.println("3.Logout");
			System.out.println("4.ViewAllusers");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			choice=scr.nextInt();
			switch(choice)
			{
			case 1:
		
				try
				{
		        System.out.print("Enter the user name");
		        scr.nextLine();
		        String username=scr.nextLine();
		        System.out.print("Enter the password");
		        String password=scr.nextLine();
		        System.out.print("Confirm password");
		        String reenterpassword=scr.nextLine();
		        System.out.print("Enter the emailid");
		        String emailid=scr.nextLine();
		        System.out.print("Enter the phonenumber");
		        String phonenumber=scr.nextLine();
		        user = new User();
		        user.setUserName(username);
		        user.setPassWord(password);
		        user.setReenterPassword(reenterpassword);
		        user.setEmail(emailid);
		        user.setPhoneNum(phonenumber);
		        userService.register(user);
				}
				catch(Exception e)
				{
				e.printStackTrace();
				}
				break;
			case 2:
				try
				{
					scr.nextLine();
				System.out.println("enter the user name");
				String username1=scr.nextLine();
				System.out.println("enter the password");
				String password1=scr.nextLine();
			     userService.login(username1, password1);
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
				}
				break;
				
			case 3:
				try
				{
					scr.nextLine();
				System.out.println("enter the user name");
				String  username1=scr.nextLine();
				userService.logout(username1);
				System.out.println("Logged out successfully");
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try
				{
					list=userService.ViewAllUsers();
					for(User u:list)
					{
						System.out.println("User name="+u.getUserName());
					}
				}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				break;
		
			case 5:
				System.out.println("Thank you");
		        	return ;
		 
			}
		
	}
		}
}
