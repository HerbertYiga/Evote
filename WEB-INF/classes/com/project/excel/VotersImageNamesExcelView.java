/*    */ package com.project.excel;
/*    */ 
/*    */ import com.project.model.Student;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*    */ import org.springframework.web.servlet.view.document.AbstractExcelView;
/*    */ 
/*    */ public class VotersImageNamesExcelView extends AbstractExcelView {
/*    */   protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
/* 23 */     List<Student> imageNames = (List<Student>)model.get("list");
/* 26 */     HSSFSheet sheet = workbook.createSheet("RespondentBean");
/* 27 */     sheet.setDefaultColumnWidth(30);
/* 30 */     HSSFRow hSSFRow = sheet.createRow(0);
/* 33 */     int rowCount = 1;
/* 34 */     for (Student studentDetails : imageNames) {
/* 36 */       HSSFRow aRow = sheet.createRow(rowCount++);
/* 38 */       aRow.createCell(0).setCellValue(studentDetails.getImageLink());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\excel\VotersImageNamesExcelView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */