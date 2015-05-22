package com.rakuten.PenguinSoldiers.models.training;



import com.rakuten.PenguinSoldiers.util.form.EnumPopulate;
import com.rakuten.PenguinSoldiers.util.form.PercentCompleteType;
import com.rakuten.PenguinSoldiers.util.form.RateType;
import com.rakuten.PenguinSoldiers.util.form.YesNoType;

public class StandardQuestionnaireForm {
  
  private YesNoType helpful;
  private PercentCompleteType understand;
  
  
  private RateType atmosphere;
  private RateType trainingCourse;
  private RateType curriculumPace;
  
  private String positive;
  private String improvement;
  
  private YesNoType followUp;
  
  public RateType[] rateTypeList=EnumPopulate.populateRateType();
  public YesNoType[] yesNoTypeList=EnumPopulate.populateYesNoType();
  public PercentCompleteType[] percentCompleteTypeList=EnumPopulate.populatePercentCompleteType();
  
  private Long trainingId;
  private String trainingName;
  
  public StandardQuestionnaireForm(){
    this.rateTypeList=EnumPopulate.populateRateType();
  }
  
  public YesNoType getHelpful() {
    return helpful;
  }

  public void setHelpful(YesNoType helpful) {
    this.helpful = helpful;
  }

  

  public PercentCompleteType getUnderstand() {
    return understand;
  }

  public void setUnderstand(PercentCompleteType understand) {
    this.understand = understand;
  }

  public RateType getAtmosphere() {
    return atmosphere;
  }

  public void setAtmosphere(RateType atmosphere) {
    this.atmosphere = atmosphere;
  }

  public RateType getTrainingCourse() {
    return trainingCourse;
  }

  public void setTrainingCourse(RateType trainingCourse) {
    this.trainingCourse = trainingCourse;
  }

  public RateType getCurriculumPace() {
    return curriculumPace;
  }

  public void setCurriculumPace(RateType curriculumPace) {
    this.curriculumPace = curriculumPace;
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

  public YesNoType getFollowUp() {
    return followUp;
  }

  public void setFollowUp(YesNoType followUp) {
    this.followUp = followUp;
  }

  public RateType[] getRateTypeList() {
    return rateTypeList;
  }

  public void setRateTypeList(RateType[] rateTypeList) {
    this.rateTypeList = rateTypeList;
  }

  public YesNoType[] getYesNoTypeList() {
    return yesNoTypeList;
  }

  public void setYesNoTypeList(YesNoType[] yesNoTypeList) {
    this.yesNoTypeList = yesNoTypeList;
  }

  public PercentCompleteType[] getPercentCompleteTypeList() {
    return percentCompleteTypeList;
  }

  public void setPercentCompleteTypeList(
      PercentCompleteType[] percentCompleteTypeList) {
    this.percentCompleteTypeList = percentCompleteTypeList;
  }

  public Long getTrainingId() {
    return trainingId;
  }

  public void setTrainingId(Long trainingId) {
    this.trainingId = trainingId;
  }

  public String getTrainingName() {
    return trainingName;
  }

  public void setTrainingName(String trainingName) {
    this.trainingName = trainingName;
  }
  
  
  
}
