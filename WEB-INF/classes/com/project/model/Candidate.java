/*     */ package com.project.model;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Transient;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "candidate")
/*     */ public class Candidate {
/*     */   @Id
/*     */   @Column(name = "studentNo")
/*     */   private Long studentNo;
/*     */   
/*     */   private String candidateFirstName;
/*     */   
/*     */   private String pwd;
/*     */   
/*     */   private String sponsorship;
/*     */   
/*     */   private String citizenship;
/*     */   
/*     */   private String sex;
/*     */   
/*     */   private String residenceType;
/*     */   
/*     */   private String hall;
/*     */   
/*     */   private String programType;
/*     */   
/*     */   private String course;
/*     */   
/*     */   private String faculty;
/*     */   
/*     */   private String coordinator;
/*     */   
/*     */   private String candidateSecondName;
/*     */   
/*     */   private String imageLink;
/*     */   
/*     */   private String position;
/*     */   
/*     */   @Transient
/*     */   private MultipartFile csvFile;
/*     */   
/*     */   @Transient
/*     */   private List<MultipartFile> candidateImage;
/*     */   
/*     */   public Candidate() {}
/*     */   
/*     */   public Candidate(String candidateFirstName, String candidateSecondName, String imageLink, String position, String sex, String faculty, String programType, String residenceType, String hall, String course, String sponsorship, String citizenship, String pwd, Long studentNo, String coordinator) {
/*  55 */     this.candidateFirstName = candidateFirstName;
/*  57 */     this.candidateSecondName = candidateSecondName;
/*  58 */     this.imageLink = imageLink;
/*  60 */     this.position = position;
/*  62 */     this.sex = sex;
/*  64 */     this.faculty = faculty;
/*  65 */     this.programType = programType;
/*  67 */     this.residenceType = residenceType;
/*  69 */     this.hall = hall;
/*  71 */     this.course = course;
/*  73 */     this.sponsorship = sponsorship;
/*  75 */     this.citizenship = citizenship;
/*  77 */     this.pwd = pwd;
/*  79 */     this.studentNo = studentNo;
/*  80 */     this.coordinator = coordinator;
/*     */   }
/*     */   
/*     */   public String getPosition() {
/*  85 */     return this.position;
/*     */   }
/*     */   
/*     */   public void setPosition(String position) {
/*  89 */     this.position = position;
/*     */   }
/*     */   
/*     */   public String getImageLink() {
/*  93 */     return this.imageLink;
/*     */   }
/*     */   
/*     */   public void setImageLink(String imageLink) {
/*  97 */     this.imageLink = imageLink;
/*     */   }
/*     */   
/*     */   public String getCandidateFirstName() {
/* 101 */     return this.candidateFirstName;
/*     */   }
/*     */   
/*     */   public void setCandidateFirstName(String candidateFirstName) {
/* 105 */     this.candidateFirstName = candidateFirstName;
/*     */   }
/*     */   
/*     */   public String getCandidateSecondName() {
/* 109 */     return this.candidateSecondName;
/*     */   }
/*     */   
/*     */   public void setCandidateSecondName(String candidateSecondName) {
/* 113 */     this.candidateSecondName = candidateSecondName;
/*     */   }
/*     */   
/*     */   public List<MultipartFile> getCandidateImage() {
/* 117 */     return this.candidateImage;
/*     */   }
/*     */   
/*     */   public void setCandidateImage(List<MultipartFile> candidateImage) {
/* 121 */     this.candidateImage = candidateImage;
/*     */   }
/*     */   
/*     */   public String getSponsorship() {
/* 125 */     return this.sponsorship;
/*     */   }
/*     */   
/*     */   public void setSponsorship(String sponsorship) {
/* 129 */     this.sponsorship = sponsorship;
/*     */   }
/*     */   
/*     */   public String getPwd() {
/* 133 */     return this.pwd;
/*     */   }
/*     */   
/*     */   public void setPwd(String pwd) {
/* 137 */     this.pwd = pwd;
/*     */   }
/*     */   
/*     */   public String getCitizenship() {
/* 141 */     return this.citizenship;
/*     */   }
/*     */   
/*     */   public void setCitizenship(String citizenship) {
/* 145 */     this.citizenship = citizenship;
/*     */   }
/*     */   
/*     */   public Long getStudentNo() {
/* 149 */     return this.studentNo;
/*     */   }
/*     */   
/*     */   public void setStudentNo(Long studentNo) {
/* 153 */     this.studentNo = studentNo;
/*     */   }
/*     */   
/*     */   public String getResidenceType() {
/* 157 */     return this.residenceType;
/*     */   }
/*     */   
/*     */   public void setResidenceType(String residenceType) {
/* 161 */     this.residenceType = residenceType;
/*     */   }
/*     */   
/*     */   public String getSex() {
/* 165 */     return this.sex;
/*     */   }
/*     */   
/*     */   public void setSex(String sex) {
/* 169 */     this.sex = sex;
/*     */   }
/*     */   
/*     */   public String getHall() {
/* 173 */     return this.hall;
/*     */   }
/*     */   
/*     */   public void setHall(String hall) {
/* 177 */     this.hall = hall;
/*     */   }
/*     */   
/*     */   public String getCourse() {
/* 181 */     return this.course;
/*     */   }
/*     */   
/*     */   public void setCourse(String course) {
/* 185 */     this.course = course;
/*     */   }
/*     */   
/*     */   public String getProgramType() {
/* 189 */     return this.programType;
/*     */   }
/*     */   
/*     */   public void setProgramType(String programType) {
/* 193 */     this.programType = programType;
/*     */   }
/*     */   
/*     */   public String getFaculty() {
/* 197 */     return this.faculty;
/*     */   }
/*     */   
/*     */   public void setFaculty(String faculty) {
/* 201 */     this.faculty = faculty;
/*     */   }
/*     */   
/*     */   public String getCoordinator() {
/* 205 */     return this.coordinator;
/*     */   }
/*     */   
/*     */   public void setCoordinator(String coordinator) {
/* 209 */     this.coordinator = coordinator;
/*     */   }
/*     */   
/*     */   public MultipartFile getCsvFile() {
/* 215 */     return this.csvFile;
/*     */   }
/*     */   
/*     */   public void setCsvFile(MultipartFile csvFile) {
/* 219 */     this.csvFile = csvFile;
/*     */   }
/*     */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\model\Candidate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */