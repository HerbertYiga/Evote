package com.project.service;

import com.project.model.Candidate;
import java.util.List;

public interface CandidateService {
  void addCandidate(Candidate paramCandidate);
  
  void viewCandidateById(int paramInt);
  
  List<Candidate> listCandidates();
  
  void removeCandidate(int paramInt);
  
  List<Candidate> listCandidateByPosistion(String paramString);
  
  Candidate getCandidateById(Long paramLong);
}


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\project\service\CandidateService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */