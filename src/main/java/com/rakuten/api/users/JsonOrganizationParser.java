package com.rakuten.api.users;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.hibernate.Hibernate;

import com.mongodb.util.JSONParseException;
import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;


@Transactional
public class JsonOrganizationParser {
  
  private String url="http://rogin.cloudapp.net/api/organizations.json";
  
  
  private String managerLabel="manager";
  private String membersLabel="members";
  private String fullAccountLabel="full_account";
  
  
  
  public List<RakutenManager> parse() throws MalformedURLException, IOException{
    return parse(this.url);
  }
  
  public List<RakutenManager> parse(String url) throws MalformedURLException, IOException{
    
 // get an instance of the json parser from the json factory
    JsonFactory factory = new JsonFactory();
    JsonParser parser = factory.createJsonParser(new URL(url));
    
    
    // continue parsing the token till the end of input is reached
    int i=0;
    String managerId="";
    LinkedList<RakutenManager> ret=new LinkedList<RakutenManager>();
    LinkedList<String> members=new LinkedList<String>();
    while (!parser.isClosed()) {
      // get the token
      JsonToken token = parser.nextToken();
      
//      System.out.println(i++ +" "+token+ " "+parser.getCurrentName()+" "+parser.getText());
//      token = parser.nextToken();
//      System.out.println(token+ " "+parser.getCurrentName()+" "+parser.getText());
//      token = parser.nextToken();
//      System.out.println(token+ " "+parser.getCurrentName()+" "+parser.getText());
//      token = parser.nextToken();
//      System.out.println(token+ " "+parser.getCurrentName()+" "+parser.getText());
//      token = parser.nextToken();
//      System.out.println(token+ " "+parser.getCurrentName()+" "+parser.getText());
//      token = parser.nextToken();
//      System.out.println(token+ " "+parser.getCurrentName()+" "+parser.getText());
//      token = parser.nextToken();
//      System.out.println(token+ " "+parser.getCurrentName()+" "+parser.getText());
//      token = parser.nextToken();
//      System.out.println(token+ " "+parser.getCurrentName()+" "+parser.getText());
//      token = parser.nextToken();
//      System.out.println(token+ " "+parser.getCurrentName()+" "+parser.getText());
//      token = parser.nextToken();
//      System.out.println(token+ " "+parser.getCurrentName()+" "+parser.getText());
//      
      
      if(token==null)break;

      if (JsonToken.FIELD_NAME.equals(token) && "name".equals(parser.getCurrentName())) {
        
//        break;
      }
      
      if (JsonToken.FIELD_NAME.equals(token) && this.managerLabel.equals(parser.getCurrentName())) {
        //get manager info
        managerId=parseManager(parser);
      }
      if (JsonToken.FIELD_NAME.equals(token) && this.membersLabel.equals(parser.getCurrentName())) {
        //get members info from the same department
        members=parseMembers(parser);
        for(i=0;i<members.size();i++){
          System.out.println(managerId+" "+members.get(i));
        }
        RakutenManager rm=new RakutenManager();
        rm.setUsername(managerId);
        rm.setEmployees(members);
//        setManagers(managerId, members, ur);
//        break;
        ret.add(rm);
        System.out.println("--------------------------------------------------");
        members=new LinkedList<String>();
        managerId="";
      }
      
      
    }
    return ret;
  }
  
  public String parseManager(JsonParser parser)throws JsonParseException,IOException{
    String managerId="";
    while(!parser.isClosed()){
      JsonToken token = parser.nextToken();
      if(JsonToken.END_OBJECT.equals(token))break;
      
      if (JsonToken.FIELD_NAME.equals(token)) {
        if("employee_no".equals(parser.getCurrentName())){
          token = parser.nextToken();
//          return parser.getText();
        }else if("full_account".equals(parser.getCurrentName())){
          token = parser.nextToken();
          managerId=parser.getText();
        }else if("".equals(parser.getCurrentName())){
          
        }
        
      }
    }
    
    return managerId;
  }
  
  public LinkedList<String> parseMembers(JsonParser parser)throws JsonParseException,IOException{
    LinkedList<String> ret=new LinkedList<String>();
    while(!parser.isClosed()){
      JsonToken token = parser.nextToken();
      if(JsonToken.END_ARRAY.equals(token))break;
      
      if (JsonToken.FIELD_NAME.equals(token)) {
        if(this.fullAccountLabel.equals(parser.getCurrentName())){
          token = parser.nextToken();
          ret.add(parser.getText());
        }else if("".equals(parser.getCurrentName())){
          
        }
        
      }
    }
    
    return ret;
  }
/*
  @Transactional
  public void setManagers(String manager, List<String> members, AccountRepository ur){
    
    if(manager==null||manager.trim().equals(""))return;
    Account m=ur.findByUsername(manager);
    if(m==null)return;
    System.out.println("Set manager:"+manager);
//    m.setMembers(ur.getMembers(m));
//    Hibernate.initialize(m.getMembers());
    for(int i=0;i<members.size();i++){
      if(!manager.equals(members.get(i))){
        Account mem=ur.findByUsername(members.get(i));
        System.out.println("Add member: "+mem.getUsername());
//        mem.setManager(m);
//        mem.addManager(m);
//        mem=ur.saveOrUpdate(mem);
//        m.addMember(mem);
        
//        m=ur.save(m);
      }
    }
//    ur.save(m);
  }
  */
  
  public boolean parseChildren(JsonParser parser){
    return false;
  }
  
}
