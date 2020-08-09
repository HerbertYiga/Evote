/*     */ package com.project.controller;
/*     */ 
/*     */ import com.project.dao.ExternalDao;
/*     */ import com.project.model.Confirm;
/*     */ import com.project.model.Student;
/*     */ import com.project.model.Token;
/*     */ import com.project.model.User;
/*     */ import com.project.service.ConfirmService;
/*     */ import com.project.service.StudentService;
/*     */ import com.project.service.TokenService;
/*     */ import java.security.Principal;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ public class CommissionerController {
/*     */   private StudentService studentService;
/*     */   
/*     */   private ConfirmService confirmService;
/*     */   
/*     */   private TokenService tokenService;
/*     */   
/*     */   @Autowired
/*     */   ExternalDao externalDao;
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("tokenService")
/*     */   public void setTokenService(TokenService tokenService) {
/*  37 */     this.tokenService = tokenService;
/*     */   }
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("confirmService")
/*     */   public void setConfirmService(ConfirmService confirmService) {
/*  48 */     this.confirmService = confirmService;
/*     */   }
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("studentService")
/*     */   public void setStudentService(StudentService studentService) {
/*  56 */     this.studentService = studentService;
/*     */   }
/*     */   
/*     */   @RequestMapping({"commissionerPanel"})
/*     */   public String commisionerPanel(Principal principal, HttpServletRequest request, @ModelAttribute("student") Student student, Model model) {
/*  62 */     String username = principal.getName();
/*  64 */     User user = this.externalDao.getUserDetailsByUserName("kimc@gmail.com");
/*  66 */     model.addAttribute("user", user);
/*  68 */     return "commissionerPanel";
/*     */   }
/*     */   
/*     */   @RequestMapping({"commissioner"})
/*     */   public String commissioner(HttpServletRequest request, Model model, Token token) {
/*  75 */     return "commissioner";
/*     */   }
/*     */   
/*     */   @RequestMapping({"commissionersavevoterid"})
/*     */   public String commissionerSavVoterid(Model model, Token token) {
/*  81 */     this.tokenService.addToken(token);
/*  82 */     return "redirect:/commissionerPanel";
/*     */   }
/*     */   
/*     */   @RequestMapping({"commissionerGenerateVotingToken"})
/*     */   public String confirm(Model model, Student student) {
/*  89 */     String randomNo = this.tokenService.generateRandomNo();
/*  91 */     if (randomNo != null) {
/*  93 */       if (this.tokenService.getTokenById(randomNo) == null) {
/*  95 */         model.addAttribute("votingId", randomNo);
/*  96 */         model.addAttribute("studentNo", student.getStudentNo());
/*  98 */         return "commissionerVotingIdPage";
/*     */       } 
/* 104 */       return "";
/*     */     } 
/* 112 */     return "";
/*     */   }
/*     */   
/*     */   @RequestMapping({"commissionerChecksStudent"})
/*     */   public String check(@ModelAttribute("student") Student student, Model model, @ModelAttribute("confirm") Confirm confirm) {
/* 123 */     if (student.getStudentNo() != null) {
/* 125 */       if (this.studentService.getStudentById(student.getStudentNo()) != null) {
/* 127 */         if (this.tokenService.getVerifiedStudentById(student.getStudentNo()) == null) {
/* 129 */           Student details = this.studentService.getStudentById(student.getStudentNo());
/* 131 */           Long currentStudentNo = details.getStudentNo();
/* 133 */           confirm.setCurrentStudentNo(currentStudentNo);
/* 135 */           model.addAttribute("student", details);
/* 137 */           return "commissionerViewStudentDetails";
/*     */         } 
/* 140 */         model.addAttribute("error", "Arleady verified");
/* 141 */         return "commissionerPanel";
/*     */       } 
/* 146 */       model.addAttribute("error", "Enter a valid student's No");
/* 147 */       return "commissionerPanel";
/*     */     } 
/* 152 */     model.addAttribute("error", "Enter a  student's No");
/* 153 */     return "commissionerPanel";
/*     */   }
/*     */   
/*     */   @RequestMapping({"Login"})
/*     */   public String ogin() {
/* 160 */     return "Login";
/*     */   }
/*     */   
/*     */   @RequestMapping({"Logout"})
/*     */   public String Logout() {
/* 165 */     return "redirect:/Login";
/*     */   }
/*     */   
/*     */   @RequestMapping({"/"})
/*     */   public String byPassingTheIndexPage() {
/* 171 */     return "redirect:/Login";
/*     */   }
/*     */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\controller\CommissionerController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */