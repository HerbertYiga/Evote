/*    */ package com.project.service;
/*    */ 
/*    */ import com.project.dao.VotesDao;
/*    */ import com.project.model.Votes;
/*    */ import javax.transaction.Transactional;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class VotesServiceImpl implements VotesService {
/*    */   private VotesDao votesDao;
/*    */   
/*    */   public void setVotesDao(VotesDao votesDao) {
/* 17 */     this.votesDao = votesDao;
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void addVotes(Votes votes) {
/* 24 */     this.votesDao.addVotes(votes);
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\VotesServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */