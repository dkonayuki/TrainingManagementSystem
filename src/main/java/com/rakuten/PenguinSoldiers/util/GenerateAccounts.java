package com.rakuten.PenguinSoldiers.util;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.Hierarchy;
import com.rakuten.PenguinSoldiers.models.account.HierarchyRepository;
import com.rakuten.api.users.JsonOrganizationParser;
import com.rakuten.api.users.JsonUsersParser;
import com.rakuten.api.users.RakutenManager;

public class GenerateAccounts {
  
  
  public static void generate(AccountRepository ar){
    JsonUsersParser jup=new JsonUsersParser();
    try{
      LinkedList<Account> list=jup.parse();
      
      for(int i=0;i<list.size();i++){
        Account a=list.get(i);
        if(a.getEmail()==null||a.getEmail().equals("null")){
          a.setEmail(a.getUsername()+"@rakuten.com");
          System.out.println(i+" "+a.getName()+" no email: generated dummy email");
        }
        
        if(ar.findByEmail(a.getEmail())==null){
          ar.save(a);
        }else{
          System.out.println(i+" "+a.getName()+"/"+a.getEmail()+" already in db "+a.getId());
        }
        
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public static void generateOrg(AccountRepository ar, HierarchyRepository hr){
    JsonOrganizationParser jup=new JsonOrganizationParser();
    try{
      List<RakutenManager> l=jup.parse();
      for(int i=0;i<l.size();i++){
        
        RakutenManager rm=l.get(i);
        Account man=ar.findByUsername(rm.getUsername());
        if(man==null){
          System.out.println(rm.getUsername()+" not found");
          continue;
        }
        for(int j=0;j<rm.getEmployees().size();j++){
          Hierarchy h=new Hierarchy();
          
          Account mem=ar.findByUsername(rm.getEmployees().get(j));
          
          if(mem==null){
            System.out.println("member "+rm.getEmployees().get(j)+" not found");
            continue;
          }else if(mem.isSame(man))continue;
          h.setEmployeeId(man.getId());
          h.setManagerId(mem.getId());
          if(!hr.isExist(h))
            hr.save(h);
//          else System.out.println(h.getManagerId()+"-"+h.getEmployeeId()+" already added");
        }
      }
      
    }catch(Exception e){
      e.printStackTrace();
    }
  }

}
