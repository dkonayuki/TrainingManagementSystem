package com.rakuten.PenguinSoldiers.util.form;

import com.rakuten.PenguinSoldiers.models.training.StandardQuestionaire;
import com.rakuten.PenguinSoldiers.models.training.StandardQuestionaireForm;

public class QuestionaireConverter {
  
  public static StandardQuestionaire toStandardQuestionaire(StandardQuestionaireForm sqf){
    StandardQuestionaire sq=new StandardQuestionaire();

    sq.setHelpful(sqf.getHelpful().toString());
    sq.setUnderstand(sqf.getUnderstand().toString());
    sq.setAtmosphere(sqf.getAtmosphere().toString());
    sq.setTrainingCourse(sqf.getTrainingCourse().toString());
    sq.setCurriculumPace(sqf.getCurriculumPace().toString());
    
    sq.setPositive(sqf.getPositive());
    sq.setImprovement(sqf.getImprovement());
    sq.setFollowUp(sqf.getFollowUp().toString());
    
    sq.setTrainingId(sqf.getTrainingId());
    
    return sq;
  }

}
