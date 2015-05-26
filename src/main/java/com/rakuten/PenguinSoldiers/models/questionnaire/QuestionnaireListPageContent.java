package com.rakuten.PenguinSoldiers.models.questionnaire;

import java.util.LinkedList;
import java.util.List;

public class QuestionnaireListPageContent {
  private List<QuestionnaireListUnit> l;
  
  public void addQuestionnaireListUnit(QuestionnaireListUnit qlu){
    if(l==null)l=new LinkedList<QuestionnaireListUnit>();
    l.add(qlu);
  }
  
  public QuestionnaireListUnit getQuestionnaireListUnit(int i){
    if(l==null)return null;
    if(i>this.l.size())return null;
    return this.l.get(i);
  }
  
  public boolean removeQuestionnaireListUnit(int i){
    return false;
  }
  
  public List<QuestionnaireListUnit> getList(){
    return this.l;
  }
}

