package com.rakuten.PenguinSoldiers.models.account;

import java.util.List;

import javax.persistence.*;
import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rakuten.PenguinSoldiers.models.admin.Admin;

@Repository
@Transactional
public class AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	private PasswordEncoder passwordEncoder;

	@Transactional
	public Account save(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
//	  account.setPassword(passwordEncoder.encode("raku10"));
		entityManager.persist(account);
		return account;
	}
	
	public Account findById(Long id) {
	  try {
      return entityManager.createNamedQuery(Account.FIND_BY_ID, Account.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
	}
	
	public Account findByEmail(String email) {
		try {
			return entityManager.createNamedQuery(Account.FIND_BY_EMAIL, Account.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	public Account findByUsername(String username) {
    try {
      return entityManager.createNamedQuery(Account.FIND_BY_USERNAME, Account.class)
          .setParameter("username", username)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	
	public List<Account> findEmployee(String username){
	  try {
	    return entityManager.createNamedQuery(Account.FIND_EMPLOYEE, Account.class)
      .setParameter("username", username).getResultList();
    } catch (PersistenceException e) {
      return null;
    }
	}
	
	public Account findManagerOne(String username){
	  List<Account> l=findManager(username);
	  if(l==null)return null;
	  else return l.get(0);
	}
	
	public List<Account> findManager(String username){
    try {
      return entityManager.createNamedQuery(Account.FIND_MANAGER, Account.class)
      .setParameter("username", username).getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	public List<Account> listAdmins(){
    try {
      return entityManager.createNamedQuery(Account.LIST_ADMIN, Account.class).getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	public boolean isManager(String username){
	  return findEmployee(username)!=null;
	}

}
