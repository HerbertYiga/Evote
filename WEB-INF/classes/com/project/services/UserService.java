package com.project.service;

import com.project.model.User;
import java.util.List;

public interface UserService {
  void addUser(User paramUser);
  
  List<User> listUser();
  
  void removeUser(int paramInt);
}


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\UserService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */