package com.rakuten.PenguinSoldiers.models.account;

public class ChangePassForm {
  
  private static final String NOT_CONFIRMED = "changePass.notConfirmed"; 
  private static final String OLD_PASSWORD_WRONG = "changePass.oldPassWrong";
  
  private String oldPass;
  private String newPass;
  private String cNewPass;
  
  
//  @NotConfirmed(message = ChangePassForm.NOT_CONFIRMED)
//  @OldPassWrong(message = ChangePassForm.OLD_PASSWORD_WRONG)
  
  public String getOldPass() {
    return oldPass;
  }
  public void setOldPass(String oldPass) {
    this.oldPass = oldPass;
  }
  public String getNewPass() {
    return newPass;
  }
  public void setNewPass(String newPass) {
    this.newPass = newPass;
  }
  public String getCNewPass() {
    return cNewPass;
  }
  public void setCNewPass(String cNewPass) {
    this.cNewPass = cNewPass;
  }
  
  public boolean isConfirmed(){
    return this.getNewPass().equals(this.getCNewPass());
  }
  
}
