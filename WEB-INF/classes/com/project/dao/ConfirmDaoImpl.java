/*    */ package com.project.dao;
/*    */ 
/*    */ import com.project.model.Confirm;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class ConfirmDaoImpl implements ConfirmDao {
/*    */   private SessionFactory sessionFactory;
/*    */   
/*    */   public void setSessionFactory(SessionFactory sessionFactory) {
/* 18 */     this.sessionFactory = sessionFactory;
/*    */   }
/*    */   
/*    */   public void confirmStudent(Confirm confirm) {
/* 22 */     Session session = this.sessionFactory.getCurrentSession();
/* 23 */     session.persist(confirm);
/*    */   }
/*    */   
/*    */   public Confirm getConfirmedStudentById(Long studentNo) {
/* 28 */     Session session = this.sessionFactory.getCurrentSession();
/*    */     try {
/* 30 */       Confirm confirm = (Confirm)session.load(Confirm.class, new Long(studentNo.longValue()));
/* 32 */       return confirm;
/* 36 */     } catch (Exception e) {
/* 38 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\dao\ConfirmDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */