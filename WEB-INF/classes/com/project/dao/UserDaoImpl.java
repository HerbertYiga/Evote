/*    */ package com.project.dao;
/*    */ 
/*    */ import com.project.model.User;
/*    */ import java.util.List;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class UserDaoImpl implements UserDao {
/*    */   private SessionFactory sessionFactory;
/*    */   
/*    */   public void setSessionFactory(SessionFactory sessionFactory) {
/* 17 */     this.sessionFactory = sessionFactory;
/*    */   }
/*    */   
/*    */   public void addUser(User user) {
/*    */     try {
/* 25 */       Session session = this.sessionFactory.getCurrentSession();
/* 26 */       session.persist(user);
/* 28 */     } catch (Exception e) {
/* 30 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public List<User> listUser() {
/* 41 */     Session session = this.sessionFactory.getCurrentSession();
/* 43 */     List<User> list = session.createQuery("from User order by userId desc").list();
/* 44 */     return list;
/*    */   }
/*    */   
/*    */   public void removeUser(int id) {}
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\dao\UserDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */