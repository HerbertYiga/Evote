/*     */ package com.project.controller;
/*     */ 
/*     */ import com.project.dao.ExternalDao;
/*     */ import com.project.model.Candidate;
/*     */ import com.project.model.ExternalModel;
/*     */ import com.project.model.Student;
/*     */ import com.project.model.Token;
/*     */ import com.project.model.Votes;
/*     */ import com.project.service.CandidateService;
/*     */ import com.project.service.StudentService;
/*     */ import com.project.service.TokenService;
/*     */ import com.project.service.VotesService;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ public class StudentController {
/*     */   private TokenService tokenService;
/*     */   
/*     */   private CandidateService candidateService;
/*     */   
/*     */   private VotesService votesService;
/*     */   
/*     */   private StudentService studentService;
/*     */   
/*     */   @Autowired
/*     */   ExternalDao externalDao;
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("studentService")
/*     */   public void setStudentService(StudentService studentService) {
/*  41 */     this.studentService = studentService;
/*     */   }
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("votesService")
/*     */   public void setVotesService(VotesService votesService) {
/*  49 */     this.votesService = votesService;
/*     */   }
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("candidateService")
/*     */   public void setCandidateService(CandidateService candidateService) {
/*  57 */     this.candidateService = candidateService;
/*     */   }
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("tokenService")
/*     */   public void setTokenService(TokenService tokenService) {
/*  65 */     this.tokenService = tokenService;
/*     */   }
/*     */   
/*     */   @RequestMapping({"Thanks"})
/*     */   public String Thanks(Model model) {
/*  71 */     return "Thanks";
/*     */   }
/*     */   
/*     */   @RequestMapping({"studentPanel"})
/*     */   public String studentPanel(Model model) {
/*  77 */     return "studentPanel";
/*     */   }
/*     */   
/*     */   @RequestMapping({"savevote"})
/*     */   public String savevote(Votes votes, Model model, ExternalModel externalModel) {
/*  83 */     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
/*  84 */     LocalDateTime now = LocalDateTime.now();
/*  85 */     votes.setTime(dtf.format(now));
/*  87 */     this.votesService.addVotes(votes);
/*  89 */     String voteId = votes.getVoteToken();
/*  90 */     Long studentNo = votes.getStudentNo();
/*  94 */     externalModel.setVoteId(voteId);
/*  95 */     externalModel.setStudentNo(studentNo);
/*  96 */     this.externalDao.saveUsedTokens(externalModel);
/* 101 */     return "redirect:/Thanks";
/*     */   }
/*     */   
/*     */   @RequestMapping({"checkvoter"})
/*     */   public String checkVoter(Model model, Token token) {
/* 110 */     if (token.getVoteId() != null) {
/* 112 */       if (this.tokenService.getTokenById(token.getVoteId()) != null) {
/* 115 */         Token tkn = this.tokenService.getTokenById(token.getVoteId());
/* 116 */         Long studentNo = tkn.getStudentNo();
/* 118 */         Student student = this.studentService.getStudentById(studentNo);
/* 119 */         model.addAttribute("student", student);
/* 120 */         model.addAttribute("voteId", token.getVoteId());
/* 123 */         List<Candidate> list = this.candidateService.listCandidateByPosistion("GUILD PRESIDENT");
/* 125 */         model.addAttribute("listOne", list);
/* 126 */         List<Candidate> list2 = this.candidateService.listCandidateByPosistion("FACULTY GRC");
/* 128 */         model.addAttribute("listTwo", list2);
/* 130 */         List<Candidate> list3 = this.candidateService.listCandidateByPosistion("HALL GRC");
/* 132 */         model.addAttribute("listThree", list3);
/* 133 */         List<Candidate> list4 = this.candidateService.listCandidateByPosistion("GRC PRIVATE STUDENTS");
/* 135 */         model.addAttribute("listFour", list4);
/* 136 */         List<Candidate> list5 = this.candidateService.listCandidateByPosistion("GRC GOVERNMENT STUDENTS");
/* 137 */         model.addAttribute("listFive", list5);
/* 138 */         List<Candidate> list6 = this.candidateService.listCandidateByPosistion("GRC EVENING STUDENTS");
/* 140 */         model.addAttribute("listSix", list6);
/* 141 */         List<Candidate> list7 = this.candidateService.listCandidateByPosistion("GRC NONRESIDENTS");
/* 143 */         model.addAttribute("listSeven", list7);
/* 144 */         List<Candidate> list8 = this.candidateService.listCandidateByPosistion("GRC COORDINDATORS");
/* 146 */         model.addAttribute("listEight", list8);
/* 147 */         List<Candidate> list9 = this.candidateService.listCandidateByPosistion("GRC PWD");
/* 149 */         model.addAttribute("listNine", list9);
/* 150 */         List<Candidate> list10 = this.candidateService.listCandidateByPosistion("GRC INTERNATIONAL STUDENTS");
/* 152 */         model.addAttribute("listTen", list10);
/* 153 */         List<Candidate> list11 = this.candidateService.listCandidateByPosistion("HALL CHAIRPERSON");
/* 155 */         model.addAttribute("listEleven", list11);
/* 159 */         return "ballotPaper";
/*     */       } 
/* 165 */       model.addAttribute("error", "Enter a valid voter's id");
/* 166 */       return "studentPanel";
/*     */     } 
/* 172 */     model.addAttribute("error", "checking the details a bit!");
/* 173 */     return "studentPanel";
/*     */   }
/*     */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\controller\StudentController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */