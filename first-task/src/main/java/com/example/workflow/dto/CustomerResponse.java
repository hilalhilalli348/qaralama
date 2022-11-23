package com.example.workflow.dto;

import com.example.workflow.model.Account;

import java.io.Serializable;
import java.util.List;

public class CustomerResponse implements Serializable {
    private String name;
    private String surname;
    private List<AccountResponse> accountList;
    public CustomerResponse(String name, String surname, List<AccountResponse> accountList) {
        this.name = name;
        this.surname = surname;
        this.accountList = accountList;
    }

    public CustomerResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<AccountResponse> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountResponse> accountList) {
        this.accountList = accountList;
    }
}
