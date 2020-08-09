/*    */ package com.project.service;
/*    */ 
/*    */ import com.project.dao.UserDao;
/*    */ import com.project.model.User;
/*    */ import java.util.List;
/*    */ import javax.transaction.Transactional;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class UserServiceImpl implements UserService {
/*    */   private UserDao userDao;
/*    */   
/*    */   public void setUserDao(UserDao userDao) {
/* 20 */     this.userDao = userDao;
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void addUser(User user) {
/* 26 */     this.userDao.addUser(user);
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public List<User> listUser() {
/* 35 */     return this.userDao.listUser();
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void removeUser(int id) {}
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\UserServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */