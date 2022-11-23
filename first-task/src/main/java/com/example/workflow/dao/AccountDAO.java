package com.example.workflow.dao;

import com.example.workflow.dto.AccountResponse;
import com.example.workflow.model.Account;
import org.camunda.bpm.engine.authorization.TaskPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.data.jpa.repository.EntityGraph.*;

@Repository
public class AccountDAO {


    private final EntityManager entityManager;

    @Autowired
    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<AccountResponse> getAllAcount(){
        List<Account> accountList = entityManager.createQuery("select a from Account a").getResultList();
        List<AccountResponse> accountResponseList = accountToAccountResponse(accountList);
        return accountResponseList;
    }

    private List<AccountResponse> accountToAccountResponse(List<Account> accountList) {
        return accountList.stream().map(account -> {
            return new AccountResponse(account.getAccountNumber(),account.getBalance(),account.getCurrency());
        }).toList();
    }

}
