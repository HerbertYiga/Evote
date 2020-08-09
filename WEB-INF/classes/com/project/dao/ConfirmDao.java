package com.project.dao;

import com.project.model.Confirm;

public interface ConfirmDao {
  void confirmStudent(Confirm paramConfirm);
  
  Confirm getConfirmedStudentById(Long paramLong);
}


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\dao\ConfirmDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */