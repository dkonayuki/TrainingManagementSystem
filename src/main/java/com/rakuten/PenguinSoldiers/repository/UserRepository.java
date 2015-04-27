package com.rakuten.PenguinSoldiers.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.account.Account;
import com.rakuten.PenguinSoldiers.entity.User;


@Repository
@Transactional(readOnly = true)
public class UserRepository {

  
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Inject
  private PasswordEncoder passwordEncoder;
  
  @Transactional
  public User save(User user) {
    entityManager.persist(user);
    return user;
  }
  

}
