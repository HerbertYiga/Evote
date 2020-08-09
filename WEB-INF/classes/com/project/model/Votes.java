/*     */ package com.project.model;
/*     */ 
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Transient;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "votes")
/*     */ public class Votes {
/*     */   @Id
/*     */   @Column(name = "voteId")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   private Long voteId;
/*     */   
/*     */   @Transient
/*     */   private String voteToken;
/*     */   
/*     */   @Transient
/*     */   private Long StudentNo;
/*     */   
/*     */   private Long guild;
/*     */   
/*     */   private String time;
/*     */   
/*     */   private Long hallchair;
/*     */   
/*     */   private Long hallgrc;
/*     */   
/*     */   private Long facultygrc;
/*     */   
/*     */   private Long privategrc;
/*     */   
/*     */   private Long governmentgrc;
/*     */   
/*     */   private Long eveningrc;
/*     */   
/*     */   private Long nonresidencegrc;
/*     */   
/*     */   private Long coordinatorgrc;
/*     */   
/*     */   private Long pwdgrc;
/*     */   
/*     */   private Long internationalgrc;
/*     */   
/*     */   public Long getVoteId() {
/*  41 */     return this.voteId;
/*     */   }
/*     */   
/*     */   public void setVoteId(Long voteId) {
/*  45 */     this.voteId = voteId;
/*     */   }
/*     */   
/*     */   public Long getGuild() {
/*  49 */     return this.guild;
/*     */   }
/*     */   
/*     */   public void setGuild(Long guild) {
/*  53 */     this.guild = guild;
/*     */   }
/*     */   
/*     */   public String getTime() {
/*  57 */     return this.time;
/*     */   }
/*     */   
/*     */   public void setTime(String time) {
/*  61 */     this.time = time;
/*     */   }
/*     */   
/*     */   public Long getHallchair() {
/*  65 */     return this.hallchair;
/*     */   }
/*     */   
/*     */   public void setHallchair(Long hallchair) {
/*  69 */     this.hallchair = hallchair;
/*     */   }
/*     */   
/*     */   public Long getHallgrc() {
/*  73 */     return this.hallgrc;
/*     */   }
/*     */   
/*     */   public void setHallgrc(Long hallgrc) {
/*  77 */     this.hallgrc = hallgrc;
/*     */   }
/*     */   
/*     */   public Long getFacultygrc() {
/*  81 */     return this.facultygrc;
/*     */   }
/*     */   
/*     */   public void setFacultygrc(Long facultygrc) {
/*  85 */     this.facultygrc = facultygrc;
/*     */   }
/*     */   
/*     */   public Long getPrivategrc() {
/*  89 */     return this.privategrc;
/*     */   }
/*     */   
/*     */   public void setPrivategrc(Long privategrc) {
/*  93 */     this.privategrc = privategrc;
/*     */   }
/*     */   
/*     */   public Long getGovernmentgrc() {
/*  97 */     return this.governmentgrc;
/*     */   }
/*     */   
/*     */   public void setGovernmentgrc(Long governmentgrc) {
/* 101 */     this.governmentgrc = governmentgrc;
/*     */   }
/*     */   
/*     */   public Long getEveningrc() {
/* 105 */     return this.eveningrc;
/*     */   }
/*     */   
/*     */   public void setEveningrc(Long eveningrc) {
/* 109 */     this.eveningrc = eveningrc;
/*     */   }
/*     */   
/*     */   public Long getNonresidencegrc() {
/* 113 */     return this.nonresidencegrc;
/*     */   }
/*     */   
/*     */   public void setNonresidencegrc(Long nonresidencegrc) {
/* 117 */     this.nonresidencegrc = nonresidencegrc;
/*     */   }
/*     */   
/*     */   public Long getCoordinatorgrc() {
/* 121 */     return this.coordinatorgrc;
/*     */   }
/*     */   
/*     */   public void setCoordinatorgrc(Long coordinatorgrc) {
/* 125 */     this.coordinatorgrc = coordinatorgrc;
/*     */   }
/*     */   
/*     */   public Long getPwdgrc() {
/* 129 */     return this.pwdgrc;
/*     */   }
/*     */   
/*     */   public void setPwdgrc(Long pwdgrc) {
/* 133 */     this.pwdgrc = pwdgrc;
/*     */   }
/*     */   
/*     */   public Long getInternationalgrc() {
/* 137 */     return this.internationalgrc;
/*     */   }
/*     */   
/*     */   public void setInternationalgrc(Long internationalgrc) {
/* 141 */     this.internationalgrc = internationalgrc;
/*     */   }
/*     */   
/*     */   public String getVoteToken() {
/* 145 */     return this.voteToken;
/*     */   }
/*     */   
/*     */   public void setVoteToken(String voteToken) {
/* 149 */     this.voteToken = voteToken;
/*     */   }
/*     */   
/*     */   public Long getStudentNo() {
/* 153 */     return this.StudentNo;
/*     */   }
/*     */   
/*     */   public void setStudentNo(Long studentNo) {
/* 157 */     this.StudentNo = studentNo;
/*     */   }
/*     */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\model\Votes.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */