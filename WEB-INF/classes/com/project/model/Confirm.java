/*    */ package com.project.model;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Transient;
/*    */ import org.hibernate.annotations.Proxy;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "confirmation")
/*    */ @Proxy(lazy = false)
/*    */ public class Confirm {
/*    */   @Id
/*    */   @Column(name = "studentNo")
/*    */   private Long studentNo;
/*    */   
/*    */   @Transient
/*    */   private Long currentStudentNo;
/*    */   
/*    */   public Long getStudentNo() {
/* 30 */     return this.studentNo;
/*    */   }
/*    */   
/*    */   public void setStudentNo(Long studentNo) {
/* 34 */     this.studentNo = studentNo;
/*    */   }
/*    */   
/*    */   public Long getCurrentStudentNo() {
/* 38 */     return this.currentStudentNo;
/*    */   }
/*    */   
/*    */   public void setCurrentStudentNo(Long currentStudentNo) {
/* 42 */     this.currentStudentNo = currentStudentNo;
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\model\Confirm.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */