/*     */ package com.project.model;
/*     */ 
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.PrimaryKeyJoinColumn;
/*     */ import javax.persistence.SecondaryTable;
/*     */ import javax.persistence.SecondaryTables;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Transient;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "users")
/*     */ @SecondaryTables({@SecondaryTable(name = "user_roles", pkJoinColumns = {@PrimaryKeyJoinColumn(name = "userId")})})
/*     */ public class User {
/*     */   @Id
/*     */   @Column(name = "userId")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   private int userId;
/*     */   
/*     */   private String firstName;
/*     */   
/*     */   private String username;
/*     */   
/*     */   private String pollingStation;
/*     */   
/*     */   private String secondName;
/*     */   
/*     */   private String password;
/*     */   
/*     */   private int contact;
/*     */   
/*     */   private int enable;
/*     */   
/*     */   @Column(name = "role", table = "user_roles")
/*     */   private String role;
/*     */   
/*     */   @Transient
/*     */   private String confirmPassword;
/*     */   
/*     */   public String getConfirmPassword() {
/*  40 */     return this.confirmPassword;
/*     */   }
/*     */   
/*     */   public void setConfirmPassword(String confirmPassword) {
/*  44 */     this.confirmPassword = confirmPassword;
/*     */   }
/*     */   
/*     */   public int getUserId() {
/*  48 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(int userId) {
/*  52 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/*  56 */     return this.firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String firstName) {
/*  60 */     this.firstName = firstName;
/*     */   }
/*     */   
/*     */   public String getSecondName() {
/*  64 */     return this.secondName;
/*     */   }
/*     */   
/*     */   public void setSecondName(String secondName) {
/*  68 */     this.secondName = secondName;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/*  72 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/*  76 */     this.password = password;
/*     */   }
/*     */   
/*     */   public int getContact() {
/*  80 */     return this.contact;
/*     */   }
/*     */   
/*     */   public void setContact(int contact) {
/*  84 */     this.contact = contact;
/*     */   }
/*     */   
/*     */   public int getEnable() {
/*  88 */     return this.enable;
/*     */   }
/*     */   
/*     */   public void setEnable(int enable) {
/*  92 */     this.enable = enable;
/*     */   }
/*     */   
/*     */   public String getRole() {
/*  96 */     return this.role;
/*     */   }
/*     */   
/*     */   public void setRole(String role) {
/* 100 */     this.role = role;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/* 104 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/* 108 */     this.username = username;
/*     */   }
/*     */   
/*     */   public String getPollingStation() {
/* 112 */     return this.pollingStation;
/*     */   }
/*     */   
/*     */   public void setPollingStation(String pollingStation) {
/* 116 */     this.pollingStation = pollingStation;
/*     */   }
/*     */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\model\User.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */