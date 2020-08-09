/*    */ package com.project.dao;
/*    */ 
/*    */ import com.project.model.Student;
/*    */ import java.util.List;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class StudentDaoImpl implements StudentDao {
/*    */   private SessionFactory sessionFactory;
/*    */   
/*    */   public void setSessionFactory(SessionFactory sessionFactory) {
/* 18 */     this.sessionFactory = sessionFactory;
/*    */   }
/*    */   
/*    */   public Student getStudentById(Long studentNo) {
/* 22 */     Session session = this.sessionFactory.getCurrentSession();
/*    */     try {
/* 24 */       Student student = (Student)session.load(Student.class, new Long(studentNo.longValue()));
/* 26 */       return student;
/* 30 */     } catch (Exception e) {
/* 32 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void addStudent(Student student) {
/* 38 */     Session session = this.sessionFactory.getCurrentSession();
/* 39 */     session.persist(student);
/*    */   }
/*    */   
/*    */   public void loadData() {
/*    */     try {
/* 46 */       Session session = this.sessionFactory.getCurrentSession();
/* 48 */     } catch (Exception exception) {}
/*    */   }
/*    */   
/*    */   public void enableStudent(int studentNo) {}
/*    */   
/*    */   public void disablStudent(int studentNo) {}
/*    */   
/*    */   public List<Student> listStudent() {
/* 66 */     Session session = this.sessionFactory.getCurrentSession();
/* 68 */     List<Student> list = session.createQuery("from Student order by studentNo desc").list();
/* 69 */     return list;
/*    */   }
/*    */   
/*    */   public void removeStudent(int id) {}
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\dao\StudentDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */