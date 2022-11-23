package com.example.workflow.dao;


import com.example.workflow.dto.AccountResponse;
import com.example.workflow.dto.CustomerRequest;
import com.example.workflow.dto.CustomerResponse;
import com.example.workflow.exception.CustomerNotFoundException;
import com.example.workflow.model.Account;
import com.example.workflow.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class CustomerDAO {

    private final EntityManager entityManager;

    @Autowired
    public CustomerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    public CustomerResponse getCustomer(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        if (customer!=null){
            CustomerResponse customerResponse = new CustomerResponse(
                    customer.getName(),
                    customer.getSurname(),
                    accountToAccountResponse(customer.getAccountList())
            );
            return customerResponse;
        }
        return null;
    }


    private List<AccountResponse> accountToAccountResponse(List<Account> accountList) {
        return accountList.stream().map(account -> {
            return new AccountResponse(account.getAccountNumber(), account.getBalance(), account.getCurrency());
        }).toList();
    }


}

