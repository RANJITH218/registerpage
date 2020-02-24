package com.cg.go.dao;




import java.util.List;

import com.cg.go.Exception.UserException;
import com.cg.go.bean.User;

public interface UserDao
{
      public void register(User user) throws UserException;
      public boolean login(String str1, String str2)  throws UserException;
      public boolean logout(String str) throws UserException;
      public List<User> ViewAllUsers() throws UserException;
      
}
