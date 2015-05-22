package com.rakuten.PenguinSoldiers.models.account;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePassFormValidator implements Validator{
  
//which objects can be validated by this validator
  @Override
  public boolean supports(Class<?> paramClass) {
      return ChangePassForm.class.equals(paramClass);
  }

  @Override
  public void validate(Object obj, Errors errors) {
//      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cNewPass", "id.required");
       
//      Employee emp = (Employee) obj;
//      if(emp.getId() <=0){
//          errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
//      }
       ChangePassForm cpf=(ChangePassForm)obj;
       if(!cpf.isConfirmed()){
         errors.rejectValue("cNewPass", "changePass.notConfirmed");
//         errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
       }
//      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
//      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
  }

}
