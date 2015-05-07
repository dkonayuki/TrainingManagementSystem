package com.rakuten.PenguinSoldiers.staff;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rakuten.PenguinSoldiers.entity.User;
import com.rakuten.PenguinSoldiers.repository.UserRepository;


@Controller
public class JsonUserParser {
  
  private String url="http://rogin.cloudapp.net/api/users.json";
  
  private String fullAccountLabel="full_account";
  private String nameLabel="name";
  private String employeeLabel="employee_no";
  private String emailLabel="email";
  
  
  public LinkedList<User> parse()throws MalformedURLException, IOException{
    return parse(this.url);
  }
  
  public LinkedList<User> parse(String url) throws MalformedURLException, IOException{
    

    // get an instance of the json parser from the json factory
       JsonFactory factory = new JsonFactory();
       JsonParser parser = factory.createJsonParser(new URL(url));
       
       
    // continue parsing the token till the end of input is reached
       
    LinkedList<User> users=new LinkedList<User>();
    while (!parser.isClosed()) {
      JsonToken token = parser.nextToken();
      if(token==null)break;
     
//      ur.save(u);
      if ("{".equals(parser.getText())) {
        User u=parseUser(parser, token);
        if(u!=null)
          users.add(u);
      }
      
    }
   
    return users;
  }
  
  public User parseUser(JsonParser parser, JsonToken token)throws MalformedURLException, IOException{
    User u=new User(); 
    while(!parser.getText().equals("}")){
      token=parser.nextToken();
      if (JsonToken.FIELD_NAME.equals(token) && this.fullAccountLabel.equals(parser.getCurrentName())) {
        token = parser.nextToken();
        u.setUsername(parser.getText());
      }
//      token = parser.nextToken();
      if (JsonToken.FIELD_NAME.equals(token) && this.nameLabel.equals(parser.getCurrentName())) {
        token = parser.nextToken();
        u.setName(parser.getText());
      }
//      token = parser.nextToken();
      if (JsonToken.FIELD_NAME.equals(token) && this.employeeLabel.equals(parser.getCurrentName())) {
        token = parser.nextToken();
        u.setEmployeeId(Long.parseLong(parser.getText()));
      }
//      token = parser.nextToken();
      if (JsonToken.FIELD_NAME.equals(token) && this.emailLabel.equals(parser.getCurrentName())) {
        token = parser.nextToken();
        u.setEmail(parser.getText());
      }
      
    }
    return u;
  }
  
}
