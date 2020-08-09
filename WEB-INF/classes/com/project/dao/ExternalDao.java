/*     */ package com.project.dao;
/*     */ 
/*     */ import com.project.model.Candidate;
/*     */ import com.project.model.ExternalModel;
/*     */ import com.project.model.Student;
/*     */ import com.project.model.User;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.jdbc.core.BatchPreparedStatementSetter;
/*     */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*     */ import org.springframework.jdbc.core.JdbcTemplate;
/*     */ import org.springframework.jdbc.core.RowMapper;
/*     */ 
/*     */ public class ExternalDao {
/*     */   JdbcTemplate template;
/*     */   
/*     */   public void setTemplate(JdbcTemplate template) {
/*  31 */     this.template = template;
/*     */   }
/*     */   
/*     */   public User getPollingStation(String username) {
/*     */     try {
/*  42 */       String sql = "select * from users where users.username=?";
/*  43 */       return (User)this.template.queryForObject(sql, new Object[] { username }, (RowMapper)new BeanPropertyRowMapper(User.class));
/*  47 */     } catch (Exception e) {
/*  49 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Candidate> getCandidateImages() {
/*     */     try {
/*  58 */       return this.template.query("select imageLink from candidateImages", new RowMapper<Candidate>() {
/*     */             public Candidate mapRow(ResultSet rs, int row) throws SQLException {
/*  62 */               Candidate imageLinks = new Candidate();
/*  64 */               imageLinks.setImageLink(rs.getString("imageLink"));
/*  66 */               return imageLinks;
/*     */             }
/*     */           });
/*  71 */     } catch (NumberFormatException nfe) {
/*  73 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Candidate> readCandidatesFromCSV(String fileName) {
/*  80 */     List<Candidate> candidates = new ArrayList<>();
/*  82 */     Path pathToFile = Paths.get(fileName, new String[0]);
/*     */     try {
/*  86 */       Exception exception2, exception1 = null;
/* 109 */     } catch (IOException ioe) {
/* 110 */       ioe.printStackTrace();
/*     */     } 
/* 113 */     return candidates;
/*     */   }
/*     */   
/*     */   private static Candidate createCandidate(String[] metadata) {
/* 119 */     String candidateFirstName = metadata[0];
/* 121 */     String candidateSecondName = metadata[1];
/* 122 */     String imageLink = metadata[2];
/* 124 */     String position = metadata[3];
/* 125 */     String sex = metadata[4];
/* 127 */     String faculty = metadata[5];
/* 129 */     String programType = metadata[6];
/* 130 */     String residenceType = metadata[7];
/* 131 */     String hall = metadata[8];
/* 132 */     String course = metadata[9];
/* 133 */     String sponsorship = metadata[10];
/* 134 */     String citizenship = metadata[11];
/* 135 */     String pwd = metadata[12];
/* 136 */     Long studentNo = Long.valueOf(Long.parseLong(metadata[13]));
/* 137 */     String coordinator = metadata[14];
/* 140 */     return new Candidate(candidateFirstName, candidateSecondName, imageLink, position, sex, faculty, programType, 
/* 141 */         residenceType, hall, course, sponsorship, citizenship, pwd, studentNo, coordinator);
/*     */   }
/*     */   
/*     */   public void insertCsvForCandidateDetails(final List<Candidate> details) {
/*     */     try {
/* 148 */       String sql = "insert into candidate (candidateFirstName,candidateSecondName,imageLink,position,sex,faculty,programType,residenceType,hall,course,sponsorship,citizenship,pwd,studentNo,coordinator)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/* 150 */       this.template.batchUpdate(sql, new BatchPreparedStatementSetter() {
/*     */             public void setValues(PreparedStatement ps, int i) throws SQLException {
/* 154 */               Candidate person = details.get(i);
/* 156 */               ps.setString(1, person.getCandidateFirstName());
/* 157 */               ps.setString(2, person.getCandidateSecondName());
/* 158 */               ps.setString(3, person.getImageLink());
/* 159 */               ps.setString(4, person.getPosition());
/* 160 */               ps.setString(5, person.getSex());
/* 161 */               ps.setString(6, person.getFaculty());
/* 162 */               ps.setString(7, person.getProgramType());
/* 163 */               ps.setString(8, person.getResidenceType());
/* 165 */               ps.setString(9, person.getHall());
/* 166 */               ps.setString(10, person.getCourse());
/* 167 */               ps.setString(11, person.getSponsorship());
/* 168 */               ps.setString(12, person.getCitizenship());
/* 170 */               ps.setString(13, person.getPwd());
/* 172 */               ps.setLong(14, person.getStudentNo().longValue());
/* 173 */               ps.setString(15, person.getCoordinator());
/*     */             }
/*     */             
/*     */             public int getBatchSize() {
/* 180 */               return details.size();
/*     */             }
/*     */           });
/* 187 */     } catch (Exception e) {
/* 189 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insertCandidateImages(final List<String> imageNames) {
/*     */     try {
/* 199 */       String sql = "insert into candidateImages (imageLink) values(?)";
/* 201 */       this.template.batchUpdate(sql, new BatchPreparedStatementSetter() {
/*     */             public void setValues(PreparedStatement ps, int i) throws SQLException {
/* 205 */               Candidate candidate = new Candidate();
/* 206 */               String imageName = imageNames.get(i);
/* 207 */               candidate.setImageLink(imageName);
/* 208 */               ps.setString(1, candidate.getImageLink());
/*     */             }
/*     */             
/*     */             public int getBatchSize() {
/* 215 */               return imageNames.size();
/*     */             }
/*     */           });
/* 222 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public int updateUser(User userdetails) {
/*     */     try {
/* 231 */       String sql = "update users INNER JOIN user_roles on users.userId=user_roles.userId set users.pollingStation='" + 
/* 232 */         userdetails.getPollingStation() + "',users.firstName='" + userdetails.getFirstName() + 
/* 233 */         "',users.secondName='" + userdetails.getSecondName() + "',users.username='" + 
/* 234 */         userdetails.getUsername() + "',users.contact='" + userdetails.getContact() + "',user_roles.role='" + 
/* 235 */         userdetails.getRole() + "' WHERE users.userId=" + userdetails.getUserId() + " ";
/* 237 */       return this.template.update(sql);
/* 241 */     } catch (Exception e) {
/* 243 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public User getUserDetailsByUserId(Integer id) {
/*     */     try {
/* 252 */       String sql = "select users.pollingStation,users.contact,users.enable,users.username,users.password,users.firstName,users.secondName,users.userId,user_roles.role from users INNER JOIN  user_roles ON users.userId=user_roles.userId where users.userId=?";
/* 253 */       return (User)this.template.queryForObject(sql, new Object[] { id }, (RowMapper)new BeanPropertyRowMapper(User.class));
/* 257 */     } catch (Exception e) {
/* 259 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public User getUserDetailsByUserName(String userName) {
/*     */     try {
/* 268 */       String sql = "select users.userId,users.firstName,users.secondName,users.password,users.contact,users.enable,users.username,users.pollingStation,user_roles.userRoleId,user_roles.roles from users  INNER JOIN user_roles ON users.userId=user_roles.userId where users.username=?";
/* 270 */       return (User)this.template.queryForObject(sql, new Object[] { userName }, (RowMapper)new BeanPropertyRowMapper(User.class));
/* 274 */     } catch (Exception e) {
/* 276 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int enableUser(int userId) {
/*     */     try {
/* 285 */       String sql = "update users set enable=1 WHERE userId=" + userId;
/* 287 */       return this.template.update(sql);
/* 291 */     } catch (Exception e) {
/* 293 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int disableUser(int userId) {
/*     */     try {
/* 302 */       String sql = "update users set enable=0 WHERE userId=" + userId;
/* 304 */       return this.template.update(sql);
/* 308 */     } catch (Exception e) {
/* 310 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Candidate getCandiateDetailsById(Long studentNo) {
/*     */     try {
/* 320 */       String sql = "select * from candidate where candidate.studentNo=?";
/* 321 */       return (Candidate)this.template.queryForObject(sql, new Object[] { studentNo }, (RowMapper)new BeanPropertyRowMapper(Candidate.class));
/* 326 */     } catch (Exception e) {
/* 328 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int updateVoterDetails(Student userdetails) {
/*     */     try {
/* 336 */       String sql = "update students set students.names='" + userdetails.getNames() + "',students.sex='" + 
/* 337 */         userdetails.getSex() + "',students.programType='" + userdetails.getProgramType() + 
/* 338 */         "',students.residenceType='" + userdetails.getResidenceType() + "',students.sponsorship='" + 
/* 339 */         userdetails.getSponsorship() + "',students.citizenship='" + userdetails.getCitizenship() + 
/* 340 */         "',students.faculty='" + userdetails.getFaculty() + "',students.pwd='" + userdetails.getPwd() + 
/* 341 */         "',students.coordinator='" + userdetails.getCoordinator() + "',students.hall='" + 
/* 342 */         userdetails.getHall() + "',students.course='" + userdetails.getCourse() + 
/* 343 */         "' WHERE students.studentNo=" + userdetails.getStudentNo() + " ";
/* 345 */       return this.template.update(sql);
/* 349 */     } catch (Exception e) {
/* 351 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Student getStudentDetailsById(Long studentNo) {
/*     */     try {
/* 360 */       String sql = "select * from students where students.studentNo=?";
/* 361 */       return (Student)this.template.queryForObject(sql, new Object[] { studentNo }, (RowMapper)new BeanPropertyRowMapper(Student.class));
/* 365 */     } catch (Exception e) {
/* 367 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateImageLinks(final List<Student> imageNames) {
/* 374 */     String sql = "update imagesToBeStored set imageLink=?";
/* 376 */     this.template.batchUpdate(sql, new BatchPreparedStatementSetter() {
/*     */           public void setValues(PreparedStatement ps, int i) throws SQLException {
/* 380 */             Student student = imageNames.get(i);
/* 382 */             ps.setString(1, student.getImageLink());
/*     */           }
/*     */           
/*     */           public int getBatchSize() {
/* 389 */             return imageNames.size();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<ExternalModel> getStudentDetails() {
/*     */     try {
/* 400 */       return this.template.query(
/* 401 */           "select students.sex,students.faculty,students.programType,students.residenceType,students.hall,students.course,students.sponsorship,students.citizenship,students.pwd,students.names,students.studentNo,students.coordinator,students.imageLink from students", 
/* 402 */           new RowMapper<ExternalModel>() {
/*     */             public ExternalModel mapRow(ResultSet rs, int row) throws SQLException {
/* 406 */               ExternalModel details = new ExternalModel();
/* 408 */               details.setSex(rs.getString("sex"));
/* 410 */               details.setFaculty(rs.getString("faculty"));
/* 412 */               details.setProgramType(rs.getString("programType"));
/* 414 */               details.setResidenceType(rs.getString("residenceType"));
/* 416 */               details.setHall(rs.getString("hall"));
/* 418 */               details.setCourse(rs.getString("course"));
/* 420 */               details.setSponsorship(rs.getString("sponsorship"));
/* 421 */               details.setCitizenship(rs.getString("citizenship"));
/* 422 */               details.setPwd(rs.getString("pwd"));
/* 423 */               details.setNames(rs.getString("names"));
/* 424 */               details.setStudentNo(Long.valueOf(rs.getLong("studentNo")));
/* 425 */               details.setCoordinator(rs.getString("coordinator"));
/* 426 */               details.setImageLink(rs.getString("imageLink"));
/* 428 */               return details;
/*     */             }
/*     */           });
/* 433 */     } catch (NumberFormatException nfe) {
/* 435 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insertStudentNoAndImages(final List<Student> details) {
/* 441 */     String sql = "insert into imagesAndStudentNo (studentNo)  values(?)";
/* 443 */     this.template.batchUpdate(sql, new BatchPreparedStatementSetter() {
/*     */           public void setValues(PreparedStatement ps, int i) throws SQLException {
/* 447 */             Student person = details.get(i);
/* 448 */             ps.setLong(1, person.getStudentNo().longValue());
/*     */           }
/*     */           
/*     */           public int getBatchSize() {
/* 455 */             return details.size();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void insertStudentImagesAndStudentNos(final List<Student> imageNames) {
/*     */     try {
/* 466 */       String sql = "insert into imagesToBeStored (imageLink) values(?)";
/* 468 */       this.template.batchUpdate(sql, new BatchPreparedStatementSetter() {
/*     */             public void setValues(PreparedStatement ps, int i) throws SQLException {
/* 472 */               Student student = imageNames.get(i);
/* 474 */               ps.setString(1, student.getImageLink());
/* 476 */               ps.setLong(2, student.getStudentNo().longValue());
/*     */             }
/*     */             
/*     */             public int getBatchSize() {
/* 483 */               return imageNames.size();
/*     */             }
/*     */           });
/* 490 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public List<Student> getListOfStudentNos() {
/*     */     try {
/* 501 */       return this.template.query(
/* 502 */           "select students.studentNo,imagesToBeStored.imageLink from students inner join imagesToBeStored", 
/* 503 */           new RowMapper<Student>() {
/*     */             public Student mapRow(ResultSet rs, int row) throws SQLException {
/* 507 */               Student studentNos = new Student();
/* 509 */               studentNos.setStudentNo(Long.valueOf(rs.getLong("studentNo")));
/* 511 */               studentNos.setImageLink(rs.getString("imageLink"));
/* 513 */               return studentNos;
/*     */             }
/*     */           });
/* 519 */     } catch (NumberFormatException nfe) {
/* 521 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Student> getImagesToBeAppendedWithStudentNo() {
/*     */     try {
/* 530 */       return this.template.query("select imageLink from imagesToBeStored", new RowMapper<Student>() {
/*     */             public Student mapRow(ResultSet rs, int row) throws SQLException {
/* 534 */               Student imageLinks = new Student();
/* 536 */               imageLinks.setImageLink(rs.getString("imageLink"));
/* 538 */               return imageLinks;
/*     */             }
/*     */           });
/* 543 */     } catch (NumberFormatException nfe) {
/* 545 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insertStudentImages(final List<String> imageNames) {
/*     */     try {
/* 552 */       String sql = "insert into imagesToBeStored (imageLink) values(?)";
/* 554 */       this.template.batchUpdate(sql, new BatchPreparedStatementSetter() {
/*     */             public void setValues(PreparedStatement ps, int i) throws SQLException {
/* 558 */               Student student = new Student();
/* 559 */               String imageName = imageNames.get(i);
/* 560 */               student.setImageLink(imageName);
/* 561 */               ps.setString(1, student.getImageLink());
/*     */             }
/*     */             
/*     */             public int getBatchSize() {
/* 568 */               return imageNames.size();
/*     */             }
/*     */           });
/* 575 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public List<Student> readStudentFromCSV(String fileName) {
/* 584 */     List<Student> books = new ArrayList<>();
/* 586 */     Path pathToFile = Paths.get(fileName, new String[0]);
/*     */     try {
/* 590 */       Exception exception2, exception1 = null;
/* 613 */     } catch (IOException ioe) {
/* 614 */       ioe.printStackTrace();
/*     */     } 
/* 617 */     return books;
/*     */   }
/*     */   
/*     */   private static Student createStudent(String[] metadata) {
/* 623 */     String sex = metadata[0];
/* 625 */     String programType = metadata[1];
/* 626 */     String residenceType = metadata[2];
/* 627 */     String hall = metadata[3];
/* 629 */     String course = metadata[4];
/* 630 */     String sponsorship = metadata[5];
/* 631 */     String citizenship = metadata[6];
/* 632 */     String pwd = metadata[7];
/* 633 */     String names = metadata[8];
/* 635 */     Long studentNo = Long.valueOf(Long.parseLong(metadata[9]));
/* 637 */     String coordinator = metadata[10];
/* 638 */     String imageLink = metadata[11];
/* 640 */     String faculty = metadata[12];
/* 643 */     return new Student(sex, programType, residenceType, hall, course, sponsorship, citizenship, pwd, names, 
/* 644 */         studentNo, coordinator, imageLink, faculty);
/*     */   }
/*     */   
/*     */   public void insertCsvForStudentDetails(final List<Student> details) {
/*     */     try {
/* 651 */       String sql = "insert into students (sex,faculty,programType,residenceType,hall,course,sponsorship,citizenship,pwd,names,studentNo,coordinator,imageLink)  values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
/* 653 */       this.template.batchUpdate(sql, new BatchPreparedStatementSetter() {
/*     */             public void setValues(PreparedStatement ps, int i) throws SQLException {
/* 657 */               Student person = details.get(i);
/* 658 */               ps.setString(1, person.getSex());
/* 659 */               ps.setString(2, person.getFaculty());
/* 661 */               ps.setString(3, person.getProgramType());
/* 662 */               ps.setString(4, person.getResidenceType());
/* 663 */               ps.setString(5, person.getHall());
/* 664 */               ps.setString(6, person.getCourse());
/* 665 */               ps.setString(7, person.getSponsorship());
/* 666 */               ps.setString(8, person.getCitizenship());
/* 667 */               ps.setString(9, person.getPwd());
/* 668 */               ps.setString(10, person.getNames());
/* 669 */               ps.setLong(11, person.getStudentNo().longValue());
/* 670 */               ps.setString(12, person.getCoordinator());
/* 671 */               ps.setString(13, person.getImageLink());
/*     */             }
/*     */             
/*     */             public int getBatchSize() {
/* 678 */               return details.size();
/*     */             }
/*     */           });
/* 685 */     } catch (Exception e) {
/* 687 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<ExternalModel> getGuildVotes() {
/*     */     try {
/* 696 */       return this.template.query(
/* 697 */           "select candidate.candidateFirstName,candidate.candidateSecondName,candidate.position,count(*) AS pollingVotes from votes inner join candidate on candidate.studentNo=votes.guild GROUP BY  candidate.studentNo", 
/* 698 */           new RowMapper<ExternalModel>() {
/*     */             public ExternalModel mapRow(ResultSet rs, int row) throws SQLException {
/* 702 */               ExternalModel details = new ExternalModel();
/* 704 */               details.setCandidateFirstName(rs.getString("candidateFirstName"));
/* 706 */               details.setCandidateSecondName(rs.getString("candidateSecondName"));
/* 708 */               details.setPosition(rs.getString("position"));
/* 710 */               details.setPollingVotes(Long.valueOf(rs.getLong("pollingVotes")));
/* 712 */               return details;
/*     */             }
/*     */           });
/* 717 */     } catch (NumberFormatException nfe) {
/* 719 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveUsedTokens(ExternalModel externalModel) {
/* 725 */     String sql = "insert into usedTokens(voteId,studentNo) values( '" + externalModel.getVoteId() + "', '" + 
/* 726 */       externalModel.getStudentNo() + "')";
/* 728 */     this.template.update(sql);
/*     */   }
/*     */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\dao\ExternalDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */