/*    */ package com.project.service;
/*    */ 
/*    */ import com.project.dao.TokenDao;
/*    */ import com.project.model.Token;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service
/*    */ public class TokenServiceImpl implements TokenService {
/*    */   private TokenDao tokenDao;
/*    */   
/*    */   public void setTokenDao(TokenDao tokenDao) {
/* 16 */     this.tokenDao = tokenDao;
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void addToken(Token token) {
/* 22 */     this.tokenDao.addToken(token);
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public Token getTokenById(String id) {
/* 30 */     return this.tokenDao.getTokenById(id);
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public String generateRandomNo() {
/* 37 */     return this.tokenDao.generateRandomNo();
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public Token getVerifiedStudentById(Long studentNo) {
/* 43 */     return this.tokenDao.getVerifiedStudentById(studentNo);
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\TokenServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */