package com.rakuten.PenguinSoldiers.models.questionnaire;

import com.rakuten.PenguinSoldiers.models.training.StandardQuestionnaire;

public class StandardQuestionnairePageContentBuilder {
  
  public static StandardQuestionnairePageContent build(StandardQuestionnaire sq){
    StandardQuestionnairePageContent sqf=new StandardQuestionnairePageContent();
    sqf.setHelpful(sq.getHelpful());
    sqf.setAtmosphere(sq.getAtmosphere());
    sqf.setCurriculumPace(sq.getCurriculumPace());
    sqf.setFollowUp(sq.getFollowUp());
    sqf.setImprovement(sq.getImprovement());
    sqf.setPositive(sq.getPositive());
    sqf.setTrainingCourse(sq.getTrainingCourse());
    sqf.setUnderstand(sq.getUnderstand());
    
    return sqf;
  }

}
