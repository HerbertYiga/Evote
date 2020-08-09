/*    */ package com.project.service;
/*    */ 
/*    */ import com.project.dao.CandidateDao;
/*    */ import com.project.model.Candidate;
/*    */ import java.util.List;
/*    */ import javax.transaction.Transactional;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class CandidateServiceImpl implements CandidateService {
/*    */   private CandidateDao candidateDao;
/*    */   
/*    */   public void setCandidateDao(CandidateDao candidateDao) {
/* 19 */     this.candidateDao = candidateDao;
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void addCandidate(Candidate candidate) {
/* 25 */     this.candidateDao.addCandidate(candidate);
/*    */   }
/*    */   
/*    */   public void viewCandidateById(int candidateId) {}
/*    */   
/*    */   @Transactional
/*    */   public List<Candidate> listCandidates() {
/* 37 */     return this.candidateDao.listCandidates();
/*    */   }
/*    */   
/*    */   public void removeCandidate(int id) {}
/*    */   
/*    */   @Transactional
/*    */   public List<Candidate> listCandidateByPosistion(String position) {
/* 48 */     return this.candidateDao.listCandidateByPosistion(position);
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public Candidate getCandidateById(Long studentNo) {
/* 53 */     return this.candidateDao.getCandidateById(studentNo);
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\CandidateServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */