package com.rakuten.PenguinSoldiers.models.questionnaire;

public class StandardQuestionnairePageContent {
  

  public String helpful;
  public String understand;
  public String atmosphere;
  public String trainingCourse;
  public String curriculumPace;
  
  public String positive;
  public String improvement;
  
  public String followUp;

  public String getHelpful() {
    return helpful;
  }

  public void setHelpful(String helpful) {
    this.helpful = this.convertYesNo(helpful);
  }

  public String getUnderstand() {
    return understand;
  }

  public void setUnderstand(String understand) {
    this.understand = this.convertPercentComplete(understand);
  }

  public String getAtmosphere() {
    return atmosphere;
  }

  public void setAtmosphere(String atmosphere) {
    this.atmosphere = this.convertRate(atmosphere);
  }

  public String getTrainingCourse() {
    return trainingCourse;
  }

  public void setTrainingCourse(String trainingCourse) {
    this.trainingCourse = this.convertRate(trainingCourse);
  }

  public String getCurriculumPace() {
    return curriculumPace;
  }

  public void setCurriculumPace(String curriculumPace) {
    this.curriculumPace = this.convertRate(curriculumPace);
  }

  public String getPositive() {
    return positive;
  }

  public void setPositive(String positive) {
    this.positive = positive;
  }

  public String getImprovement() {
    return improvement;
  }

  public void setImprovement(String improvement) {
    this.improvement = improvement;
  }

  public String getFollowUp() {
    return followUp;
  }

  public void setFollowUp(String followUp) {
    this.followUp = this.convertYesNo(followUp);
  }
  
  public String convertRate(String s){
    if(s.equals("VERY_GOOD")){
      return "Very Good!";
    }else if(s.equals("GOOD")){
      return "Good.";
    }else if(s.equals("OKAY")){
      return "Okay.";
    }else if(s.equals("BAD")){
      return "Bad.";
    }else if(s.equals("VERY_BAD")){
      return "Very Bad!!";
    }
    return null;
  }
  
  public String convertPercentComplete(String s){
    if(s.equals("ONE_HUNDRED")){
      return "100%";
    }else if(s.equals("MORE_SEVENTY")){
      return "About 70%.";
    }else if(s.equals("MORE_FIFTY")){
      return "About 50%.";
    }else if(s.equals("MORE_THIRTY")){
      return "About 30%.";
    }else if(s.equals("ZERO")){
      return "None.";
    }
    return null;
  }
  
  public String convertYesNo(String s){
    if(s.equals("YES"))
      return "Yes please.";
    else if(s.equals("MAYBE"))
      return "Not Sure.";
    return "No thank you.";
  }
}
