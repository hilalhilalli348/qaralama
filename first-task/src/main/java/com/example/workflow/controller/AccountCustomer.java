package com.example.workflow.controller;

import com.example.workflow.dao.AccountDAO;
import com.example.workflow.dto.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/accounts")
public class AccountCustomer {

    private final AccountDAO accountDAO;


    @Autowired
    public AccountCustomer(AccountDAO accountDAO ) {
        this.accountDAO = accountDAO;

    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccount(){
        List<AccountResponse> accountResponseList = accountDAO.getAllAcount();
        return ResponseEntity.ok(accountResponseList);
    }


}
