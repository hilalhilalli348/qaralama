package com.example.workflow.delegate;

import com.example.workflow.dto.CustomerResponse;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("receiveAccountDelegate")
public class ReceiveAccountDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("receive account delegate");
        CustomerResponse customerResponse = (CustomerResponse) delegateExecution.getVariable("customerResponse");


        customerResponse.getAccountList().forEach(accountResponse ->
                System.out.println(
                        accountResponse.getAccountNumber() + " / "
                                + accountResponse.getBalance() + " / "
                                + accountResponse.getCurrency()));


    }
}
