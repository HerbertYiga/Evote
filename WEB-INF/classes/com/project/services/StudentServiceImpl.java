/*    */ package com.project.service;
/*    */ 
/*    */ import com.project.dao.StudentDao;
/*    */ import com.project.model.Student;
/*    */ import java.util.List;
/*    */ import javax.transaction.Transactional;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class StudentServiceImpl implements StudentService {
/*    */   private StudentDao studentDao;
/*    */   
/*    */   public void setStudentDao(StudentDao studentDao) {
/* 20 */     this.studentDao = studentDao;
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public Student getStudentById(Long studentNo) {
/* 27 */     Student student = this.studentDao.getStudentById(studentNo);
/* 28 */     return student;
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public void addStudent(Student student) {
/* 35 */     this.studentDao.addStudent(student);
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public List<Student> listStudent() {
/* 42 */     return this.studentDao.listStudent();
/*    */   }
/*    */   
/*    */   public void enableStudent(int studentNo) {}
/*    */   
/*    */   public void disablStudent(int studentNo) {}
/*    */   
/*    */   public void removeStudent(int id) {}
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\StudentServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */