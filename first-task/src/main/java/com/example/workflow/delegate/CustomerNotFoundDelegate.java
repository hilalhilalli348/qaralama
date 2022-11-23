package com.example.workflow.delegate;

import com.example.workflow.dto.CustomerResponse;
import com.example.workflow.exception.CustomerNotFoundException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("customerNotFoundDelegate")
public class CustomerNotFoundDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("customer not found delegate");
        int id = (int) delegateExecution.getVariable("customer_id");
        throw new CustomerNotFoundException(id+" bu adli customer movcut deyil!");

    }
}
