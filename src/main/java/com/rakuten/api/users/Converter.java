package com.rakuten.api.users;

import com.rakuten.PenguinSoldiers.models.account.Account;

public class Converter {
  
  public static Account RakutenUserToAccount(RakutenUser ru){
    if(ru==null)return null;
    Account a=new Account();
    a.setEmail(ru.getEmail());
    a.setName(ru.getName());
    a.setUsername(ru.getFullAccount());
    a.setEmployeeNo(ru.getEmployeeNo());
    return a;
  }
}
