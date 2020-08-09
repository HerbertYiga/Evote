package com.project.dao;

import com.project.model.Candidate;
import com.project.model.Token;
import java.util.List;

public interface TokenDao {
  void addToken(Token paramToken);
  
  Token getTokenById(String paramString);
  
  String generateRandomNo();
  
  List<Candidate> listOfCandidates();
  
  Token getVerifiedStudentById(Long paramLong);
}


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\dao\TokenDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */