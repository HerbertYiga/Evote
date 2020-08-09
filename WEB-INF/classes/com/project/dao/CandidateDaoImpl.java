/*    */ package com.project.dao;
/*    */ 
/*    */ import com.project.model.Candidate;
/*    */ import java.util.List;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.query.Query;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class CandidateDaoImpl implements CandidateDao {
/*    */   private SessionFactory sessionFactory;
/*    */   
/*    */   public void setSessionFactory(SessionFactory sessionFactory) {
/* 19 */     this.sessionFactory = sessionFactory;
/*    */   }
/*    */   
/*    */   public void addCandidate(Candidate candidate) {
/* 24 */     Session session = this.sessionFactory.getCurrentSession();
/* 25 */     session.persist(candidate);
/*    */   }
/*    */   
/*    */   public List<Candidate> listCandidates() {
/*    */     try {
/* 33 */       Session session = this.sessionFactory.getCurrentSession();
/* 37 */       List<Candidate> list = session.createQuery("from Candidate order by candidateFirstName desc").list();
/* 38 */       return list;
/* 42 */     } catch (Exception e) {
/* 44 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void viewCandidateById(int candidateId) {}
/*    */   
/*    */   public void removeCandidate(int id) {}
/*    */   
/*    */   public List<Candidate> listCandidateByPosistion(String position) {
/* 63 */     Session session = this.sessionFactory.getCurrentSession();
/* 65 */     String hql = "from Candidate as c where c.position =:position";
/* 67 */     Query query = session.createQuery(hql);
/* 68 */     query.setString("position", position);
/* 70 */     List<Candidate> candidate = query.list();
/* 72 */     return candidate;
/*    */   }
/*    */   
/*    */   public Candidate getCandidateById(Long studentNo) {
/* 77 */     Session session = this.sessionFactory.getCurrentSession();
/*    */     try {
/* 79 */       Candidate candidate = (Candidate)session.load(Candidate.class, new Long(studentNo.longValue()));
/* 81 */       return candidate;
/* 85 */     } catch (Exception e) {
/* 87 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\dao\CandidateDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */