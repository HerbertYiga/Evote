/*     */ package com.project.controller;
/*     */ 
/*     */ import com.project.dao.ExternalDao;
/*     */ import com.project.model.Candidate;
/*     */ import com.project.model.ExternalModel;
/*     */ import com.project.model.Student;
/*     */ import com.project.service.CandidateService;
/*     */ import com.project.service.StudentService;
/*     */ import com.project.service.UserService;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.commons.beanutils.BeanComparator;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMethod;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class UserController {
/*     */   private StudentService studentService;
/*     */   
/*     */   private UserService userService;
/*     */   
/*     */   private CandidateService candidateService;
/*     */   
/*     */   @Autowired
/*     */   ExternalDao externalDao;
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("candidateService")
/*     */   public void setCandidateService(CandidateService candidateService) {
/*  52 */     this.candidateService = candidateService;
/*     */   }
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("userService")
/*     */   public void setUserService(UserService userService) {
/*  60 */     this.userService = userService;
/*     */   }
/*     */   
/*     */   @Autowired(required = true)
/*     */   @Qualifier("studentService")
/*     */   public void setStudentService(StudentService studentService) {
/*  68 */     this.studentService = studentService;
/*     */   }
/*     */   
/*     */   @RequestMapping({"userSaveCandidateCsv"})
/*     */   public String userSaveCandidateCsv(HttpServletRequest request, HttpSession session, Candidate candidate, Model model) throws FileNotFoundException, IOException {
/*  77 */     List<Candidate> candidateDetails = this.candidateService.listCandidates();
/*  79 */     if (candidateDetails != null && !candidateDetails.isEmpty()) {
/*  83 */       String uploadErrorCanidatesCsv = "Details exist!!";
/*  85 */       session.setAttribute("uploadErrorCanidatesCsv", uploadErrorCanidatesCsv);
/*  86 */       return "redirect:/userViewRegisteredCandidate";
/*     */     } 
/*  90 */     MultipartFile file = candidate.getCsvFile();
/*  92 */     String fileName = file.getOriginalFilename();
/*  94 */     File csvfile = new File(request.getServletContext().getRealPath("/resources/image"), fileName);
/*     */     try {
/*  96 */       file.transferTo(csvfile);
/*  98 */     } catch (IOException e) {
/* 100 */       e.printStackTrace();
/*     */     } 
/* 102 */     String CSV_FILE = csvfile.getAbsolutePath();
/* 104 */     List<Candidate> details = this.externalDao.readCandidatesFromCSV(CSV_FILE);
/* 106 */     this.externalDao.insertCsvForCandidateDetails(details);
/* 108 */     return "redirect:/userViewRegisteredCandidate";
/*     */   }
/*     */   
/*     */   @RequestMapping(value = {"/exportCandidateImageNames"}, method = {RequestMethod.GET})
/*     */   public ModelAndView getExcelForCandidateImageNames() {
/* 117 */     List<Candidate> list = this.externalDao.getCandidateImages();
/* 119 */     return new ModelAndView("CandidatesImageNamesExcel", "list", list);
/*     */   }
/*     */   
/*     */   @RequestMapping({"userSaveCandidatePhotos"})
/*     */   public String saveCandidatePhotos(HttpServletRequest request, HttpSession session, Candidate candidate, Model model) throws FileNotFoundException, IOException {
/* 126 */     List<MultipartFile> images = candidate.getCandidateImage();
/* 128 */     List<String> listOfImages = new ArrayList<>();
/* 130 */     List<Candidate> listOfImageNames = this.externalDao.getCandidateImages();
/* 132 */     if (listOfImageNames != null && !listOfImageNames.isEmpty()) {
/* 136 */       String candidateUploadImageErrorUser = "Candidates images Arleady exist!!";
/* 138 */       session.setAttribute("candidateUploadImageErrorUser", candidateUploadImageErrorUser);
/* 139 */       return "redirect:/userViewRegisteredCandidate";
/*     */     } 
/* 143 */     if (images != null && images.size() > 0) {
/* 145 */       for (MultipartFile multipartFile : images) {
/* 147 */         String imageName = multipartFile.getOriginalFilename();
/* 149 */         listOfImages.add(imageName);
/* 151 */         File imagefile = new File(request.getServletContext().getRealPath("/resources/image"), imageName);
/*     */         try {
/* 153 */           multipartFile.transferTo(imagefile);
/* 154 */         } catch (IOException e) {
/* 155 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 159 */       this.externalDao.insertCandidateImages(listOfImages);
/*     */     } 
/* 163 */     return "redirect:/userViewRegisteredCandidate";
/*     */   }
/*     */   
/*     */   @RequestMapping(value = {"/userViewingCamdidate/{studentNo}"}, method = {RequestMethod.GET})
/*     */   public ModelAndView userViewingCandidate(HttpServletRequest request, HttpSession session, @PathVariable Long studentNo, Model model) {
/* 172 */     session.setAttribute("studentNoToViewCandidateByUser", studentNo);
/* 174 */     return new ModelAndView("redirect:/userViewCandidate");
/*     */   }
/*     */   
/*     */   @RequestMapping(value = {"/exportVotersRegister"}, method = {RequestMethod.GET})
/*     */   public ModelAndView getExcelForVoters() {
/* 180 */     List<ExternalModel> list = this.externalDao.getStudentDetails();
/* 182 */     return new ModelAndView("VotersRegisterExcel", "list", list);
/*     */   }
/*     */   
/*     */   @RequestMapping(value = {"/exportVotersImageNames"}, method = {RequestMethod.GET})
/*     */   public ModelAndView getExcelForImageNames() {
/* 187 */     List<Student> list = this.externalDao.getImagesToBeAppendedWithStudentNo();
/* 189 */     return new ModelAndView("VotersImageNamesExcel", "list", list);
/*     */   }
/*     */   
/*     */   @RequestMapping({"userUpdateVoterDetails"})
/*     */   public String updateVoterDetails(Student student) {
/* 196 */     this.externalDao.updateVoterDetails(student);
/* 198 */     return "redirect:/user";
/*     */   }
/*     */   
/*     */   @RequestMapping(value = {"/userEditingVoter/{studentNo}"}, method = {RequestMethod.GET})
/*     */   public ModelAndView userEditingUser(HttpServletRequest request, HttpSession session, @PathVariable Long studentNo, Model model) {
/* 206 */     session.setAttribute("studentNoToEditVoterByUser", studentNo);
/* 208 */     return new ModelAndView("redirect:/userEditVoter");
/*     */   }
/*     */   
/*     */   @RequestMapping({"userEditVoter"})
/*     */   public String userEditVoter(HttpServletRequest request, HttpSession session, Model model) {
/* 216 */     Long studentNo = (Long)request.getSession().getAttribute("studentNoToEditVoterByUser");
/* 218 */     Student student = this.externalDao.getStudentDetailsById(studentNo);
/* 220 */     model.addAttribute("student", student);
/* 221 */     session.invalidate();
/* 223 */     return "userEditVoter";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userViewVoter"})
/*     */   public String userViewVoter(HttpServletRequest request, HttpSession session, Model model) {
/* 229 */     Long studentNo = (Long)request.getSession().getAttribute("studentNoToViewVoterByUser");
/* 231 */     Student student = this.externalDao.getStudentDetailsById(studentNo);
/* 233 */     model.addAttribute("student", student);
/* 234 */     session.invalidate();
/* 236 */     return "userViewVoter";
/*     */   }
/*     */   
/*     */   @RequestMapping(value = {"/userViewingVoter/{studentNo}"}, method = {RequestMethod.GET})
/*     */   public ModelAndView adminViewingVoter(HttpServletRequest request, HttpSession session, @PathVariable Long studentNo, Model model) {
/* 244 */     session.setAttribute("studentNoToViewVoterByUser", studentNo);
/* 246 */     return new ModelAndView("redirect:/userViewVoter");
/*     */   }
/*     */   
/*     */   @RequestMapping({"userSaveStudentPhotos"})
/*     */   public String saveStudentPhotos(HttpServletRequest request, HttpSession session, @ModelAttribute("student") Student student, Model model) throws FileNotFoundException, IOException {
/* 254 */     List<MultipartFile> images = Arrays.asList(student.getImages());
/* 256 */     List<String> listOfImages = new ArrayList<>();
/* 258 */     List<Student> listOfImageNames = this.externalDao.getImagesToBeAppendedWithStudentNo();
/* 260 */     if (listOfImageNames != null && !listOfImageNames.isEmpty()) {
/* 264 */       String uploadImageErrorUser = "Voters' images Arleady exist!!";
/* 266 */       session.setAttribute("uploadImageErrorUser", uploadImageErrorUser);
/* 267 */       return "redirect:/user";
/*     */     } 
/* 271 */     if (images != null && images.size() > 0) {
/* 273 */       for (MultipartFile multipartFile : images) {
/* 275 */         String imageName = multipartFile.getOriginalFilename();
/* 277 */         listOfImages.add(imageName);
/* 279 */         File imagefile = new File(request.getServletContext().getRealPath("/resources/image"), imageName);
/*     */         try {
/* 281 */           multipartFile.transferTo(imagefile);
/* 282 */         } catch (IOException e) {
/* 283 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 287 */       this.externalDao.insertStudentImages(listOfImages);
/*     */     } 
/* 291 */     return "redirect:/user";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userSaveStudentCsv"})
/*     */   public String saveCsv(HttpServletRequest request, HttpSession session, @ModelAttribute("student") Student student, Model model) throws FileNotFoundException, IOException {
/* 299 */     List<ExternalModel> studentDetails = this.externalDao.getStudentDetails();
/* 301 */     if (studentDetails != null && !studentDetails.isEmpty()) {
/* 305 */       String uploadErrorVotersCsv = "Details exist!!";
/* 307 */       session.setAttribute("uploadErrorVotersCsv", uploadErrorVotersCsv);
/* 308 */       return "redirect:/user";
/*     */     } 
/* 312 */     MultipartFile file = student.getCsvFile();
/* 314 */     String fileName = file.getOriginalFilename();
/* 316 */     File imagefile = new File(request.getServletContext().getRealPath("/resources/image"), fileName);
/*     */     try {
/* 318 */       file.transferTo(imagefile);
/* 320 */     } catch (IOException e) {
/* 322 */       e.printStackTrace();
/*     */     } 
/* 324 */     String CSV_FILE = imagefile.getAbsolutePath();
/* 326 */     List<Student> details = this.externalDao.readStudentFromCSV(CSV_FILE);
/* 328 */     this.externalDao.insertCsvForStudentDetails(details);
/* 330 */     return "redirect:/user";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userViewCandidateDetails"})
/*     */   public String userViewCandidateDetails(Model model, HttpServletRequest request, HttpSession session) {
/* 336 */     Long studentNo = (Long)request.getSession().getAttribute("studentNo");
/* 338 */     Candidate candidate = this.candidateService.getCandidateById(studentNo);
/* 340 */     model.addAttribute("candidate", candidate);
/* 342 */     return "userViewCandidateDetails";
/*     */   }
/*     */   
/*     */   @RequestMapping({"user"})
/*     */   public String user(HttpServletRequest request, HttpSession session, Model model) {
/* 350 */     List<ExternalModel> list = this.externalDao.getStudentDetails();
/* 351 */     Collections.sort(list, (Comparator<? super ExternalModel>)new BeanComparator("names"));
/* 353 */     model.addAttribute("list", list);
/* 354 */     String uploadErrorVotersCsv = (String)request.getSession().getAttribute("uploadErrorVotersCsv");
/* 355 */     model.addAttribute("uploadErrorVotersCsv", uploadErrorVotersCsv);
/* 357 */     String uploadImageErrorUser = (String)request.getSession().getAttribute("uploadImageErrorUser");
/* 358 */     model.addAttribute("uploadImageErrorUser", uploadImageErrorUser);
/* 360 */     session.invalidate();
/* 362 */     return "user";
/*     */   }
/*     */   
/*     */   @RequestMapping(value = {"/user/editCandidate/{studentNo}"}, method = {RequestMethod.GET})
/*     */   public String userEditCandidate(@PathVariable Long studentNo, Model model, HttpSession session, HttpServletRequest request) {
/* 370 */     session = request.getSession();
/* 371 */     session.setAttribute("studentNo", studentNo);
/* 372 */     return "redirect:/userViewCandidateDetails";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userRegisterCandidate"})
/*     */   public String saveCandidate(HttpServletRequest request, @ModelAttribute("candidate") Candidate candidate, Model model) {
/* 383 */     List<MultipartFile> files = candidate.getCandidateImage();
/* 385 */     List<String> fileNames = new ArrayList<>();
/* 387 */     if (files != null && files.size() > 0) {
/* 388 */       for (MultipartFile multipartFile : files) {
/* 390 */         String fileName = multipartFile.getOriginalFilename();
/* 391 */         candidate.setImageLink(fileName);
/* 393 */         fileNames.add(fileName);
/* 395 */         File imagefile = new File(request.getServletContext().getRealPath("/resources/image"), fileName);
/*     */         try {
/* 397 */           multipartFile.transferTo(imagefile);
/* 398 */         } catch (IOException e) {
/* 399 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 403 */       if (this.candidateService.getCandidateById(candidate.getStudentNo()) != null) {
/* 404 */         model.addAttribute("studentNoError", "Student No Exists hence Not Added!!");
/* 405 */         List<Candidate> list = this.candidateService.listCandidates();
/* 406 */         Collections.sort(list, (Comparator<? super Candidate>)new BeanComparator("candidateFirstName"));
/* 408 */         model.addAttribute("list", list);
/* 410 */         return "userViewRegisteredCandidate";
/*     */       } 
/* 414 */       this.candidateService.addCandidate(candidate);
/*     */     } 
/* 418 */     return "redirect:/userViewRegisteredCandidate";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userViewRegisteredCandidate"})
/*     */   public String viewRegisteredCandidates(Model model, HttpSession session, HttpServletRequest request) {
/* 423 */     List<Candidate> list = this.candidateService.listCandidates();
/* 424 */     Collections.sort(list, (Comparator<? super Candidate>)new BeanComparator("candidateFirstName"));
/* 426 */     model.addAttribute("list", list);
/* 428 */     String candidateUploadImageErrorUser = (String)request.getSession()
/* 429 */       .getAttribute("candidateUploadImageErrorUser");
/* 430 */     model.addAttribute("candidateUploadImageErrorUser", candidateUploadImageErrorUser);
/* 431 */     session.invalidate();
/* 433 */     return "userViewRegisteredCandidate";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userRegisterStudent"})
/*     */   public String saveStudent(HttpServletRequest request, @ModelAttribute("student") Student student, Model model) {
/* 443 */     List<MultipartFile> files = student.getImage();
/* 445 */     List<String> fileNames = new ArrayList<>();
/* 447 */     if (files != null && files.size() > 0) {
/* 448 */       for (MultipartFile multipartFile : files) {
/* 450 */         String fileName = multipartFile.getOriginalFilename();
/* 451 */         student.setImageLink(fileName);
/* 453 */         fileNames.add(fileName);
/* 455 */         File imagefile = new File(request.getServletContext().getRealPath("/resources/image"), fileName);
/*     */         try {
/* 457 */           multipartFile.transferTo(imagefile);
/* 458 */         } catch (IOException e) {
/* 459 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 463 */       if (this.studentService.getStudentById(student.getStudentNo()) != null) {
/* 464 */         model.addAttribute("studentNoError", "Student No Exists hence Not Added!!");
/* 465 */         List<Student> list = this.studentService.listStudent();
/* 466 */         Collections.sort(list, (Comparator<? super Student>)new BeanComparator("names"));
/* 468 */         model.addAttribute("list", list);
/* 469 */         return "user";
/*     */       } 
/* 473 */       this.studentService.addStudent(student);
/*     */     } 
/* 477 */     return "redirect:/user";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userViewRegisteredStudents"})
/*     */   public String viewRegisteredStudents(Student student, Model model) {
/* 484 */     List<Student> list = this.studentService.listStudent();
/* 486 */     model.addAttribute("list", list);
/* 488 */     return "userViewRegisteredStudents";
/*     */   }
/*     */   
/*     */   @RequestMapping({"verifyRandomNo"})
/*     */   public String verifyRandomNo(@ModelAttribute("student") Student student, Model model) {
/* 494 */     return "verifyRandomNo";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userAddBallotPaper"})
/*     */   public String addBallotPaper(@ModelAttribute("student") Student student, Model model) {
/* 502 */     return "userAddBallotPaper";
/*     */   }
/*     */   
/*     */   @RequestMapping({"index"})
/*     */   public String index(@ModelAttribute("student") Student student, Model model) {
/* 508 */     return "index";
/*     */   }
/*     */   
/*     */   @RequestMapping({"RegistrationForm"})
/*     */   public String RegistrationForm(@ModelAttribute("student") Student student, Model model) {
/* 514 */     return "RegistrationForm";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userUploadBallotDetails"})
/*     */   public String userUploadBallotDetails(@ModelAttribute("student") Student student, Model model) {
/* 520 */     return "userUploadBallotDetails";
/*     */   }
/*     */   
/*     */   @RequestMapping({"userUploadStudents"})
/*     */   public String registerStudent(@ModelAttribute("student") Student student, Model model) {
/* 526 */     return "userUploadStudents";
/*     */   }
/*     */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\controller\UserController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */