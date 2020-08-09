/*    */ package com.project.service;
/*    */ 
/*    */ import com.project.dao.ConfirmDao;
/*    */ import com.project.model.Confirm;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service
/*    */ public class ConfirmServiceImpl implements ConfirmService {
/*    */   private ConfirmDao confirmDao;
/*    */   
/*    */   public void setConfirmDao(ConfirmDao confirmDao) {
/* 17 */     this.confirmDao = confirmDao;
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void confirmStudent(Confirm confirm) {
/* 24 */     this.confirmDao.confirmStudent(confirm);
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public Confirm getConfirmedStudentById(Long studentNo) {
/* 31 */     return this.confirmDao.getConfirmedStudentById(studentNo);
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\ConfirmServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */