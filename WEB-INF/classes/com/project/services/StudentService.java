package com.project.service;

import com.project.model.Student;
import java.util.List;

public interface StudentService {
  void addStudent(Student paramStudent);
  
  void enableStudent(int paramInt);
  
  void disablStudent(int paramInt);
  
  List<Student> listStudent();
  
  void removeStudent(int paramInt);
  
  Student getStudentById(Long paramLong);
}


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\StudentService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */