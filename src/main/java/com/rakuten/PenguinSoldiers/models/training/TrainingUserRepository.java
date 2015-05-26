package com.rakuten.PenguinSoldiers.models.training;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.models.account.Account;

@Repository
@Transactional
public class TrainingUserRepository {
  
  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public TrainingUser save(TrainingUser TrainingUser) {
    entityManager.persist(TrainingUser);
    return TrainingUser;
  }

  public TrainingUser findById(int id) {
    try {
      return entityManager.createNamedQuery(TrainingUser.FIND_BY_ID, TrainingUser.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
  public List<Account> findRegisteredUser(long  trainingId, long  managerId){
    try {
      return entityManager.createNamedQuery(TrainingUser.FIND_REGISTERED_EMPLOYEE, Account.class)
          .setParameter("managerId", managerId)
          .setParameter("trainingId", trainingId).getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
  public List<Account> findCompletedQuestionnaire(long  trainingId, long  managerId){
    try {
      
      
      return entityManager.createNamedQuery(TrainingUser.FIND_COMPLETED_QUESTIONNAIRE, Account.class)
          .setParameter("managerId", managerId)
          .setParameter("trainingId", trainingId).getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
  public List<Account> findNotRegisteredUser(long trainingId, long managerId){
    try {
      return entityManager.createNamedQuery(TrainingUser.FIND_NOT_REGISTERED_EMPLOYEE, Account.class)
          .setParameter("managerId", managerId)
          .setParameter("trainingId", trainingId).getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
  public Account findByAccountUsername(String username) {
    try {
      return entityManager.createNamedQuery(Account.FIND_BY_USERNAME, Account.class)
          .setParameter("username", username)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
  
  public void update(TrainingUser TrainingUser) {
    entityManager.merge(TrainingUser);
  }

  public void delete(TrainingUser TrainingUser) {
    entityManager.remove(entityManager.contains(TrainingUser) ? TrainingUser : entityManager.merge(TrainingUser));
  }
  
  public List<TrainingUser> findAll() {
    return entityManager.createQuery("from TrainingUser", TrainingUser.class).getResultList();
  }

  
  public boolean isExist(TrainingUser tu) {
    try {
      return this.findByTrainingIdAndAccountId(tu.getTrainingId(), tu.getUserId())!=null;
    } catch (PersistenceException e) {
      return false;
    }
  }
  
  public TrainingUser findByTrainingIdAndAccountId(Long trainingId,Long accountId){
    try {
      return entityManager.createNamedQuery(TrainingUser.FIND_BY_TRAININIG_ID_ACCOUNT_ID, TrainingUser.class)
          .setParameter("trainingId", trainingId)
          .setParameter("accountId", accountId)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
  
  
  

}
