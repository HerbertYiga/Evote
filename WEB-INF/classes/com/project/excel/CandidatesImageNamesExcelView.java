/*    */ package com.project.excel;
/*    */ 
/*    */ import com.project.model.Candidate;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*    */ import org.springframework.web.servlet.view.document.AbstractExcelView;
/*    */ 
/*    */ public class CandidatesImageNamesExcelView extends AbstractExcelView {
/*    */   protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 23 */     List<Candidate> imageNames = (List<Candidate>)model.get("list");
/* 26 */     HSSFSheet sheet = workbook.createSheet("RespondentBean");
/* 27 */     sheet.setDefaultColumnWidth(30);
/* 30 */     HSSFRow hSSFRow = sheet.createRow(0);
/* 33 */     int rowCount = 1;
/* 34 */     for (Candidate candidateDetails : imageNames) {
/* 36 */       HSSFRow aRow = sheet.createRow(rowCount++);
/* 38 */       aRow.createCell(0).setCellValue(candidateDetails.getImageLink());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\excel\CandidatesImageNamesExcelView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */