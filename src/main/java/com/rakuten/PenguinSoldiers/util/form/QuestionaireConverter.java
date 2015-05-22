package com.rakuten.PenguinSoldiers.util.form;

import com.rakuten.PenguinSoldiers.models.training.StandardQuestionnaire;
import com.rakuten.PenguinSoldiers.models.training.StandardQuestionnaireForm;

public class QuestionaireConverter {
  
  public static StandardQuestionnaire toStandardQuestionaire(StandardQuestionnaireForm sqf){
    StandardQuestionnaire sq=new StandardQuestionnaire();

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
