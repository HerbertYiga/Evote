/*    */ package com.project.model;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "tokens")
/*    */ public class Token {
/*    */   @Id
/*    */   @Column(name = "voteId")
/*    */   private String voteId;
/*    */   
/*    */   private Long studentNo;
/*    */   
/*    */   public String getVoteId() {
/* 22 */     return this.voteId;
/*    */   }
/*    */   
/*    */   public void setVoteId(String voteId) {
/* 26 */     this.voteId = voteId;
/*    */   }
/*    */   
/*    */   public Long getStudentNo() {
/* 30 */     return this.studentNo;
/*    */   }
/*    */   
/*    */   public void setStudentNo(Long studentNo) {
/* 34 */     this.studentNo = studentNo;
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\model\Token.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */