package com.example.workflow.delegate;

import com.example.workflow.dto.CustomerResponse;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkCustomerDelegate")
public class CheckCustomerDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("check customer delegate");
        CustomerResponse customerResponse = (CustomerResponse) delegateExecution.getVariable("customerResponse");

        if (customerResponse!=null){
         delegateExecution.setVariable("customerExsist",true);
        }else {
            delegateExecution.setVariable("customerExsist",false);
        }


    }
}
