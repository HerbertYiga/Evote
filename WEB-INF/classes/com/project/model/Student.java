/*     */ package com.project.model;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Transient;
/*     */ import org.hibernate.annotations.Proxy;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "students")
/*     */ @Proxy(lazy = false)
/*     */ public class Student {
/*     */   @Id
/*     */   @Column(name = "studentNo")
/*     */   private Long studentNo;
/*     */   
/*     */   private String names;
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
/*     */   @Transient
/*     */   private MultipartFile[] images;
/*     */   
/*     */   @Transient
/*     */   private List<MultipartFile> image;
/*     */   
/*     */   @Transient
/*     */   private MultipartFile csvFile;
/*     */   
/*     */   @Transient
/*     */   MultipartFile file;
/*     */   
/*     */   private String imageLink;
/*     */   
/*     */   private String pwd;
/*     */   
/*     */   private String sponsorship;
/*     */   
/*     */   private String citizenship;
/*     */   
/*     */   public Student() {}
/*     */   
/*     */   public Student(String sex, String programType, String residenceType, String hall, String course, String sponsorship, String citizenship, String pwd, String names, Long studentNo, String coordinator, String imageLink, String faculty) {
/*  63 */     this.sex = sex;
/*  64 */     this.programType = programType;
/*  65 */     this.residenceType = residenceType;
/*  66 */     this.hall = hall;
/*  67 */     this.course = course;
/*  68 */     this.sponsorship = sponsorship;
/*  69 */     this.citizenship = citizenship;
/*  70 */     this.pwd = pwd;
/*  71 */     this.names = names;
/*  72 */     this.studentNo = studentNo;
/*  73 */     this.coordinator = coordinator;
/*  74 */     this.imageLink = imageLink;
/*  75 */     this.faculty = faculty;
/*     */   }
/*     */   
/*     */   public Long getStudentNo() {
/*  83 */     return this.studentNo;
/*     */   }
/*     */   
/*     */   public void setStudentNo(Long studentNo) {
/*  87 */     this.studentNo = studentNo;
/*     */   }
/*     */   
/*     */   public String getSex() {
/*  91 */     return this.sex;
/*     */   }
/*     */   
/*     */   public void setSex(String sex) {
/*  95 */     this.sex = sex;
/*     */   }
/*     */   
/*     */   public String getResidenceType() {
/*  99 */     return this.residenceType;
/*     */   }
/*     */   
/*     */   public void setResidenceType(String residenceType) {
/* 103 */     this.residenceType = residenceType;
/*     */   }
/*     */   
/*     */   public String getHall() {
/* 107 */     return this.hall;
/*     */   }
/*     */   
/*     */   public void setHall(String hall) {
/* 111 */     this.hall = hall;
/*     */   }
/*     */   
/*     */   public String getProgramType() {
/* 115 */     return this.programType;
/*     */   }
/*     */   
/*     */   public void setProgramType(String programType) {
/* 119 */     this.programType = programType;
/*     */   }
/*     */   
/*     */   public String getCourse() {
/* 123 */     return this.course;
/*     */   }
/*     */   
/*     */   public void setCourse(String course) {
/* 127 */     this.course = course;
/*     */   }
/*     */   
/*     */   public String getFaculty() {
/* 131 */     return this.faculty;
/*     */   }
/*     */   
/*     */   public void setFaculty(String faculty) {
/* 135 */     this.faculty = faculty;
/*     */   }
/*     */   
/*     */   public String getPwd() {
/* 139 */     return this.pwd;
/*     */   }
/*     */   
/*     */   public void setPwd(String pwd) {
/* 143 */     this.pwd = pwd;
/*     */   }
/*     */   
/*     */   public String getSponsorship() {
/* 147 */     return this.sponsorship;
/*     */   }
/*     */   
/*     */   public void setSponsorship(String sponsorship) {
/* 151 */     this.sponsorship = sponsorship;
/*     */   }
/*     */   
/*     */   public String getCitizenship() {
/* 155 */     return this.citizenship;
/*     */   }
/*     */   
/*     */   public void setCitizenship(String citizenship) {
/* 159 */     this.citizenship = citizenship;
/*     */   }
/*     */   
/*     */   public String getImageLink() {
/* 163 */     return this.imageLink;
/*     */   }
/*     */   
/*     */   public void setImageLink(String imageLink) {
/* 167 */     this.imageLink = imageLink;
/*     */   }
/*     */   
/*     */   public String getNames() {
/* 171 */     return this.names;
/*     */   }
/*     */   
/*     */   public void setNames(String names) {
/* 175 */     this.names = names;
/*     */   }
/*     */   
/*     */   public List<MultipartFile> getImage() {
/* 179 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(List<MultipartFile> image) {
/* 183 */     this.image = image;
/*     */   }
/*     */   
/*     */   public MultipartFile getFile() {
/* 187 */     return this.file;
/*     */   }
/*     */   
/*     */   public void setFile(MultipartFile file) {
/* 191 */     this.file = file;
/*     */   }
/*     */   
/*     */   public String getCoordinator() {
/* 195 */     return this.coordinator;
/*     */   }
/*     */   
/*     */   public void setCoordinator(String coordinator) {
/* 199 */     this.coordinator = coordinator;
/*     */   }
/*     */   
/*     */   public MultipartFile getCsvFile() {
/* 203 */     return this.csvFile;
/*     */   }
/*     */   
/*     */   public void setCsvFile(MultipartFile csvFile) {
/* 207 */     this.csvFile = csvFile;
/*     */   }
/*     */   
/*     */   public MultipartFile[] getImages() {
/* 212 */     return this.images;
/*     */   }
/*     */   
/*     */   public void setImages(MultipartFile[] images) {
/* 217 */     this.images = images;
/*     */   }
/*     */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\model\Student.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */