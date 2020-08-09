/*    */ package com.project.dao;
/*    */ 
/*    */ import com.project.model.Candidate;
/*    */ import com.project.model.Token;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.query.Query;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class TokenDaoImpl implements TokenDao {
/*    */   private SessionFactory sessionFactory;
/*    */   
/*    */   public void setSessionFactory(SessionFactory sessionFactory) {
/* 21 */     this.sessionFactory = sessionFactory;
/*    */   }
/*    */   
/*    */   public void addToken(Token token) {
/* 25 */     Session session = this.sessionFactory.getCurrentSession();
/* 26 */     session.persist(token);
/*    */   }
/*    */   
/*    */   public String generateRandomNo() {
/* 31 */     Random random = new Random();
/* 33 */     int val = random.nextInt();
/* 35 */     String Hex = new String();
/* 37 */     Hex = Integer.toHexString(val);
/* 39 */     String he = Hex.toUpperCase();
/* 40 */     return he;
/*    */   }
/*    */   
/*    */   public Token getTokenById(String voteId) {
/* 48 */     Session session = this.sessionFactory.getCurrentSession();
/* 50 */     String hql = "from Token as t where t.voteId =:voteId";
/* 51 */     Query query = session.createQuery(hql);
/* 52 */     query.setString("voteId", voteId);
/* 53 */     List<Token> token = query.list();
/* 55 */     if (token != null) {
/* 56 */       Iterator<Token> iterator = token.iterator();
/* 56 */       if (iterator.hasNext()) {
/* 56 */         Token tok = iterator.next();
/* 58 */         return tok;
/*    */       } 
/*    */     } 
/* 62 */     return null;
/*    */   }
/*    */   
/*    */   public List<Candidate> listOfCandidates() {
/* 69 */     Session session = this.sessionFactory.getCurrentSession();
/* 71 */     List<Candidate> list = session.createQuery("from Candidate order by candidateId desc").list();
/* 72 */     return list;
/*    */   }
/*    */   
/*    */   public Token getVerifiedStudentById(Long studentNo) {
/* 77 */     Session session = this.sessionFactory.getCurrentSession();
/*    */     try {
/* 79 */       Token token = (Token)session.load(Token.class, new Long(studentNo.longValue()));
/* 81 */       return token;
/* 85 */     } catch (Exception e) {
/* 87 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\dao\TokenDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */