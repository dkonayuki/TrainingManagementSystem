package com.rakuten.PenguinSoldiers.models.questionnaire;

import java.math.BigInteger;
import java.util.List;

import com.rakuten.PenguinSoldiers.models.training.StandardQuestionnaireRepository;

public class QuestionnaireListPageContentBuilder {
  
  public static QuestionnaireListPageContent build(StandardQuestionnaireRepository sqr, long trainingId, long userId){
    List<Object[]> list=sqr.employeeCompleted(trainingId, userId);
    
    QuestionnaireListPageContent qlpc=new QuestionnaireListPageContent(); 
    for(int i=0;i<list.size();i++){
      Object[] o=list.get(i);
      QuestionnaireListUnit qlu=new QuestionnaireListUnit();
      qlu.setUserName((String)o[0]);
      qlu.setSqId(((BigInteger)o[1]).longValue());
      qlpc.addQuestionnaireListUnit(qlu);
    }
    return qlpc;
  }

}
