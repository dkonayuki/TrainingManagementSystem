package com.rakuten.PenguinSoldiers.util;

import java.util.HashMap;
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
//          ar.save(a);
        }else{
          list.remove(a);
          i--;
          System.out.println(i+" "+a.getName()+"/"+a.getEmail()+" already in db "+a.getId());
        }        
      }
      ar.save(list);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public static void generateOrg(AccountRepository ar, HierarchyRepository hr){
    JsonOrganizationParser jup=new JsonOrganizationParser();
    List<Hierarchy> toBeAdded=new LinkedList<Hierarchy>();
    try{
      List<RakutenManager> l=jup.parse();
      HashMap<String, String> m=new HashMap<String, String>();
      HashMap<String, Account> accounts=new HashMap<String, Account>();
      for(int i=0;i<l.size();i++){
        if(i>0&&i%100==0)
          System.out.println(i+"/"+l.size());
        RakutenManager rm=l.get(i);
        if(rm.getUsername()==null||rm.getUsername().trim().equals(""))continue;
        Account man;
        if(accounts.containsKey(rm.getUsername())){
          man=accounts.get(rm.getUsername());
        }else{
          man=ar.findByUsername(rm.getUsername());
          accounts.put(rm.getUsername(), man);
        }
        
        if(man==null){
//          System.out.println("manager: ["+rm.getUsername()+"] not found");
          continue;
        }
        for(int j=0;j<rm.getEmployees().size();j++){
          Hierarchy h=new Hierarchy();
          
          Account mem;
          if(accounts.containsKey(rm.getEmployees().get(j))){
            mem=accounts.get(rm.getEmployees().get(j));
          }else{
            mem=ar.findByUsername(rm.getEmployees().get(j));
            accounts.put(rm.getEmployees().get(j), mem);
          }
          
          if(mem==null){
//            System.out.println("member: ["+rm.getEmployees().get(j)+"] not found");
            continue;
          }else if(mem.isSame(man))continue;
          h.setEmployeeId(mem.getId());
          h.setManagerId(man.getId());
//          if(!hr.isExist(h)){
          if(!m.containsKey(h.getEmployeeId()+"-"+h.getManagerId())){
//            hr.save(h);
            m.put(h.getEmployeeId()+"-"+h.getManagerId(), "");
            toBeAdded.add(h);
          }
            
//          else System.out.println(h.getManagerId()+"-"+h.getEmployeeId()+" already added");
        }
      }
      
      System.out.println("add to hierarchy: "+toBeAdded.size());
      hr.save(toBeAdded);
      
      
    }catch(Exception e){
      e.printStackTrace();
    }
  }

}
