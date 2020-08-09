/*    */ package com.project.excel;
/*    */ 
/*    */ import com.project.model.ExternalModel;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*    */ import org.springframework.web.servlet.view.document.AbstractExcelView;
/*    */ 
/*    */ public class VotersRegisterExcelView extends AbstractExcelView {
/*    */   protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
/* 23 */     List<ExternalModel> imageNames = (List<ExternalModel>)model.get("list");
/* 26 */     HSSFSheet sheet = workbook.createSheet("RespondentBean");
/* 27 */     sheet.setDefaultColumnWidth(30);
/* 30 */     HSSFRow hSSFRow = sheet.createRow(0);
/* 33 */     int rowCount = 1;
/* 34 */     for (ExternalModel studentDetails : imageNames) {
/* 36 */       HSSFRow aRow = sheet.createRow(rowCount++);
/* 38 */       aRow.createCell(0).setCellValue(studentDetails.getStudentNo().longValue());
/* 40 */       aRow.createCell(1).setCellValue(studentDetails.getNames());
/* 42 */       aRow.createCell(2).setCellValue(studentDetails.getSex());
/* 44 */       aRow.createCell(3).setCellValue(studentDetails.getFaculty());
/* 46 */       aRow.createCell(4).setCellValue(studentDetails.getCourse());
/* 48 */       aRow.createCell(5).setCellValue(studentDetails.getProgramType());
/* 49 */       aRow.createCell(6).setCellValue(studentDetails.getSponsorship());
/* 51 */       aRow.createCell(7).setCellValue(studentDetails.getHall());
/* 53 */       aRow.createCell(8).setCellValue(studentDetails.getResidenceType());
/* 55 */       aRow.createCell(9).setCellValue(studentDetails.getCoordinator());
/* 57 */       aRow.createCell(10).setCellValue(studentDetails.getPwd());
/* 59 */       aRow.createCell(11).setCellValue(studentDetails.getCitizenship());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\excel\VotersRegisterExcelView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */