/*     */ package com.project.model;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ public class ExternalModel {
/*     */   private Long pollingVotes;
/*     */   
/*     */   private Long internationalgrc;
/*     */   
/*     */   private Long privategrc;
/*     */   
/*     */   private Long governmentgrc;
/*     */   
/*     */   private Long pwdgrc;
/*     */   
/*     */   private Long eveningrc;
/*     */   
/*     */   private Long nonresidencegrc;
/*     */   
/*     */   private Long coordinatorgrc;
/*     */   
/*     */   private Long facultygrc;
/*     */   
/*     */   private Long hallchair;
/*     */   
/*     */   private String voteId;
/*     */   
/*     */   private Long guild;
/*     */   
/*     */   private Long hallgrc;
/*     */   
/*     */   private String names;
/*     */   
/*     */   private String candidateId;
/*     */   
/*     */   private String candidateFirstName;
/*     */   
/*     */   private String pwd;
/*     */   
/*     */   private String sponsorship;
/*     */   
/*     */   private String citizenship;
/*     */   
/*     */   private List<MultipartFile> candidateImage;
/*     */   
/*     */   private Long studentNo;
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
/*     */   private String time;
/*     */   
/*     */   public String getCandidateId() {
/*  49 */     return this.candidateId;
/*     */   }
/*     */   
/*     */   public void setCandidateId(String candidateId) {
/*  53 */     this.candidateId = candidateId;
/*     */   }
/*     */   
/*     */   public String getCandidateFirstName() {
/*  57 */     return this.candidateFirstName;
/*     */   }
/*     */   
/*     */   public void setCandidateFirstName(String candidateFirstName) {
/*  61 */     this.candidateFirstName = candidateFirstName;
/*     */   }
/*     */   
/*     */   public String getPwd() {
/*  65 */     return this.pwd;
/*     */   }
/*     */   
/*     */   public void setPwd(String pwd) {
/*  69 */     this.pwd = pwd;
/*     */   }
/*     */   
/*     */   public String getSponsorship() {
/*  73 */     return this.sponsorship;
/*     */   }
/*     */   
/*     */   public void setSponsorship(String sponsorship) {
/*  77 */     this.sponsorship = sponsorship;
/*     */   }
/*     */   
/*     */   public String getCitizenship() {
/*  81 */     return this.citizenship;
/*     */   }
/*     */   
/*     */   public void setCitizenship(String citizenship) {
/*  85 */     this.citizenship = citizenship;
/*     */   }
/*     */   
/*     */   public Long getStudentNo() {
/*  89 */     return this.studentNo;
/*     */   }
/*     */   
/*     */   public void setStudentNo(Long studentNo) {
/*  93 */     this.studentNo = studentNo;
/*     */   }
/*     */   
/*     */   public String getSex() {
/*  97 */     return this.sex;
/*     */   }
/*     */   
/*     */   public void setSex(String sex) {
/* 101 */     this.sex = sex;
/*     */   }
/*     */   
/*     */   public String getResidenceType() {
/* 105 */     return this.residenceType;
/*     */   }
/*     */   
/*     */   public void setResidenceType(String residenceType) {
/* 109 */     this.residenceType = residenceType;
/*     */   }
/*     */   
/*     */   public String getHall() {
/* 113 */     return this.hall;
/*     */   }
/*     */   
/*     */   public void setHall(String hall) {
/* 117 */     this.hall = hall;
/*     */   }
/*     */   
/*     */   public String getProgramType() {
/* 121 */     return this.programType;
/*     */   }
/*     */   
/*     */   public void setProgramType(String programType) {
/* 125 */     this.programType = programType;
/*     */   }
/*     */   
/*     */   public String getCourse() {
/* 129 */     return this.course;
/*     */   }
/*     */   
/*     */   public void setCourse(String course) {
/* 133 */     this.course = course;
/*     */   }
/*     */   
/*     */   public String getFaculty() {
/* 137 */     return this.faculty;
/*     */   }
/*     */   
/*     */   public void setFaculty(String faculty) {
/* 141 */     this.faculty = faculty;
/*     */   }
/*     */   
/*     */   public String getCoordinator() {
/* 145 */     return this.coordinator;
/*     */   }
/*     */   
/*     */   public void setCoordinator(String coordinator) {
/* 149 */     this.coordinator = coordinator;
/*     */   }
/*     */   
/*     */   public String getCandidateSecondName() {
/* 153 */     return this.candidateSecondName;
/*     */   }
/*     */   
/*     */   public void setCandidateSecondName(String candidateSecondName) {
/* 157 */     this.candidateSecondName = candidateSecondName;
/*     */   }
/*     */   
/*     */   public String getImageLink() {
/* 161 */     return this.imageLink;
/*     */   }
/*     */   
/*     */   public void setImageLink(String imageLink) {
/* 165 */     this.imageLink = imageLink;
/*     */   }
/*     */   
/*     */   public String getPosition() {
/* 169 */     return this.position;
/*     */   }
/*     */   
/*     */   public void setPosition(String position) {
/* 173 */     this.position = position;
/*     */   }
/*     */   
/*     */   public List<MultipartFile> getCandidateImage() {
/* 177 */     return this.candidateImage;
/*     */   }
/*     */   
/*     */   public void setCandidateImage(List<MultipartFile> candidateImage) {
/* 181 */     this.candidateImage = candidateImage;
/*     */   }
/*     */   
/*     */   public String getTime() {
/* 185 */     return this.time;
/*     */   }
/*     */   
/*     */   public void setTime(String time) {
/* 189 */     this.time = time;
/*     */   }
/*     */   
/*     */   public Long getInternationalgrc() {
/* 193 */     return this.internationalgrc;
/*     */   }
/*     */   
/*     */   public void setInternationalgrc(Long internationalgrc) {
/* 197 */     this.internationalgrc = internationalgrc;
/*     */   }
/*     */   
/*     */   public Long getPrivategrc() {
/* 201 */     return this.privategrc;
/*     */   }
/*     */   
/*     */   public void setPrivategrc(Long privategrc) {
/* 205 */     this.privategrc = privategrc;
/*     */   }
/*     */   
/*     */   public Long getGovernmentgrc() {
/* 209 */     return this.governmentgrc;
/*     */   }
/*     */   
/*     */   public void setGovernmentgrc(Long governmentgrc) {
/* 213 */     this.governmentgrc = governmentgrc;
/*     */   }
/*     */   
/*     */   public Long getPwdgrc() {
/* 217 */     return this.pwdgrc;
/*     */   }
/*     */   
/*     */   public void setPwdgrc(Long pwdgrc) {
/* 221 */     this.pwdgrc = pwdgrc;
/*     */   }
/*     */   
/*     */   public Long getEveningrc() {
/* 225 */     return this.eveningrc;
/*     */   }
/*     */   
/*     */   public void setEveningrc(Long eveningrc) {
/* 229 */     this.eveningrc = eveningrc;
/*     */   }
/*     */   
/*     */   public Long getNonresidencegrc() {
/* 233 */     return this.nonresidencegrc;
/*     */   }
/*     */   
/*     */   public void setNonresidencegrc(Long nonresidencegrc) {
/* 237 */     this.nonresidencegrc = nonresidencegrc;
/*     */   }
/*     */   
/*     */   public Long getCoordinatorgrc() {
/* 241 */     return this.coordinatorgrc;
/*     */   }
/*     */   
/*     */   public void setCoordinatorgrc(Long coordinatorgrc) {
/* 245 */     this.coordinatorgrc = coordinatorgrc;
/*     */   }
/*     */   
/*     */   public Long getFacultygrc() {
/* 249 */     return this.facultygrc;
/*     */   }
/*     */   
/*     */   public void setFacultygrc(Long facultygrc) {
/* 253 */     this.facultygrc = facultygrc;
/*     */   }
/*     */   
/*     */   public Long getHallchair() {
/* 257 */     return this.hallchair;
/*     */   }
/*     */   
/*     */   public void setHallchair(Long hallchair) {
/* 261 */     this.hallchair = hallchair;
/*     */   }
/*     */   
/*     */   public String getVoteId() {
/* 265 */     return this.voteId;
/*     */   }
/*     */   
/*     */   public void setVoteId(String voteId) {
/* 269 */     this.voteId = voteId;
/*     */   }
/*     */   
/*     */   public Long getGuild() {
/* 273 */     return this.guild;
/*     */   }
/*     */   
/*     */   public void setGuild(Long guild) {
/* 277 */     this.guild = guild;
/*     */   }
/*     */   
/*     */   public Long getHallgrc() {
/* 281 */     return this.hallgrc;
/*     */   }
/*     */   
/*     */   public void setHallgrc(Long hallgrc) {
/* 285 */     this.hallgrc = hallgrc;
/*     */   }
/*     */   
/*     */   public Long getPollingVotes() {
/* 289 */     return this.pollingVotes;
/*     */   }
/*     */   
/*     */   public void setPollingVotes(Long pollingVotes) {
/* 293 */     this.pollingVotes = pollingVotes;
/*     */   }
/*     */   
/*     */   public String getNames() {
/* 297 */     return this.names;
/*     */   }
/*     */   
/*     */   public void setNames(String names) {
/* 301 */     this.names = names;
/*     */   }
/*     */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\model\ExternalModel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */