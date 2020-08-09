/*    */ package com.project.controller;
/*    */ 
/*    */ import com.project.dao.ExternalDao;
/*    */ import com.project.model.ExternalModel;
/*    */ import com.project.service.CandidateService;
/*    */ import com.project.service.StudentService;
/*    */ import com.project.service.TokenService;
/*    */ import com.project.service.VotesService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class TallyCenterController {
/*    */   private TokenService tokenService;
/*    */   
/*    */   private CandidateService candidateService;
/*    */   
/*    */   private VotesService votesService;
/*    */   
/*    */   private StudentService studentService;
/*    */   
/*    */   @Autowired
/*    */   ExternalDao externalDao;
/*    */   
/*    */   @Autowired(required = true)
/*    */   @Qualifier("studentService")
/*    */   public void setStudentService(StudentService studentService) {
/* 37 */     this.studentService = studentService;
/*    */   }
/*    */   
/*    */   @Autowired(required = true)
/*    */   @Qualifier("votesService")
/*    */   public void setVotesService(VotesService votesService) {
/* 45 */     this.votesService = votesService;
/*    */   }
/*    */   
/*    */   @Autowired(required = true)
/*    */   @Qualifier("candidateService")
/*    */   public void setCandidateService(CandidateService candidateService) {
/* 53 */     this.candidateService = candidateService;
/*    */   }
/*    */   
/*    */   @Autowired(required = true)
/*    */   @Qualifier("tokenService")
/*    */   public void setTokenService(TokenService tokenService) {
/* 61 */     this.tokenService = tokenService;
/*    */   }
/*    */   
/*    */   @RequestMapping({"tallyCenter"})
/*    */   public String tallyCenter(Model model) {
/* 69 */     List<ExternalModel> list = this.externalDao.getGuildVotes();
/* 70 */     model.addAttribute("list", list);
/* 72 */     return "tallyCenter";
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\controller\TallyCenterController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */