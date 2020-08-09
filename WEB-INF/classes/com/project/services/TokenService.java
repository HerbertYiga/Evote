package com.project.service;

import com.project.model.Token;

public interface TokenService {
  void addToken(Token paramToken);
  
  Token getTokenById(String paramString);
  
  String generateRandomNo();
  
  Token getVerifiedStudentById(Long paramLong);
}


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\TokenService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */