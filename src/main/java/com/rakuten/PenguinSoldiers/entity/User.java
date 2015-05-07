package com.rakuten.PenguinSoldiers.entity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transactional;




@Transactional
@SuppressWarnings("serial")
public class User implements java.io.Serializable{
  
  public static final String FIND_BY_EMPLOYEE_ID = "User.findByEmployeeId";

  
  private Long id;
  private String name;
  private String email;
  private String password;
  private Long employeeId;
  private String username;
  private Long role;
//  private User manager;
  
//  @OneToMany(fetch = FetchType.EAGER, mappedBy = "topic", cascade = CascadeType.ALL)
  private Collection<User> managers=null;//= new Collection<User>();
  private Collection<User> members=null;
  
  private Timestamp createdTimestamp;
  
  public Long getEmployeeId() {
    return employeeId;
  }
  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Long getRole() {
    return role;
  }
  public void setRole(Long role) {
    this.role = role;
  }
  public Timestamp getCreatedTimestamp() {
    return createdTimestamp;
  }
  public void setCreatedTimestamp(Timestamp createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  
  
  public Collection<User> getManagers() {
    return managers;
  }
  public void setManagers(Collection<User> managers) {
    this.managers = managers;
  }
  public Collection<User> getMembers() {
    return members;
  }
  
  public void setMembers(Collection<User> members) {
//    this.members =new HashSet<User>();
    try{
      this.members = members;
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  
  
  public void addMember(User u){
    if(this.getMembers()==null){
      this.setMembers(new HashSet<User>());
    }
    add(this.getMembers(),u);
  }
  public void removeMember(User u){
    remove(this.getMembers(),u);
  }
  
  public void addManager(User u){
    if(this.getManagers()==null){
      this.setManagers(new HashSet<User>());
    }
    add(this.getManagers(),u);
  }
  public void removeManager(User u){
    remove(this.getManagers(),u);
  }
 
  public void add(Collection<User> users, User u){
    if(users==null){
      users=new HashSet<User>();
    }
    if(this.isSame(u))return;
    if(!hasUser(users,u))users.add(u);
    else System.out.println("Already added.");
  }
  public void remove(Collection<User> users, User u){
    if(users==null)return;
    Iterator<User> iter=users.iterator();
    while(iter.hasNext()){
      User member=iter.next();
//      if(member.isSame(u))return true;
      if(member.isSame(u)){
        users.remove(member);
        return;
      }
    }
//    this.members.remove(u);
  }
  
  
  public boolean isSame(User u){
    if(this.getId()==null||u.getId()==null)return false;
    return this.getId().equals(u.getId());
  }
  
  public boolean hasUser(Collection<User> users, User u){
    if(users==null)return false;
    Iterator<User> iter=users.iterator();//this.getMembers().iterator();
    while(iter.hasNext()){
      User member=iter.next();
      if(member!=null&&member.isSame(u))return true;
    }
    return false;
  }
  
  public boolean hasDuplicates(Collection<User> users){
    HashMap<Long, User> hm=new HashMap<Long, User>();
    Iterator<User> iter=users.iterator();//this.getMembers().iterator();
    while(iter.hasNext()){
      User member=iter.next();
      if(!hm.containsKey(member.getId())){
        hm.put(member.getId(), member);
      }else return true;
    }
    return false;
  }
  
}
