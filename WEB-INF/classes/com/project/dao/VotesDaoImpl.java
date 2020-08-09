/*    */ package com.project.dao;
/*    */ 
/*    */ import com.project.model.Votes;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class VotesDaoImpl implements VotesDao {
/*    */   private SessionFactory sessionFactory;
/*    */   
/*    */   public void setSessionFactory(SessionFactory sessionFactory) {
/* 15 */     this.sessionFactory = sessionFactory;
/*    */   }
/*    */   
/*    */   public void addVotes(Votes votes) {
/* 19 */     Session session = this.sessionFactory.getCurrentSession();
/* 20 */     session.persist(votes);
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\dao\VotesDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */