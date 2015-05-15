package com.rakuten.PenguinSoldiers.controllers.training;

import com.rakuten.PenguinSoldiers.models.training.TrainingRepository;
import com.rakuten.PenguinSoldiers.models.training.TrainingUserRepository;

public class TrainingUserManageContentBuilder {
  
  public static TrainingUserManageContent build(TrainingUserRepository tur, TrainingRepository tr,int trainingId, long managerId){
    
    TrainingUserManageContent tumc=new TrainingUserManageContent();
    //find user in training;
    
    //find user not in training;
    tumc.setOut(tur.findNotRegisteredUser(trainingId, managerId));
    tumc.setIn(tur.findRegisteredUser(trainingId, managerId));
    tumc.setTraining(tr.findById(trainingId));
    return tumc;
  }

}
