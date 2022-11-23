package com.example.workflow.delegate;

import com.example.workflow.dto.AccountResponse;
import com.example.workflow.dto.CommonResponse;
import com.example.workflow.dto.CustomerResponse;
import com.example.workflow.dto.Status;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("receiveAccountDelegate")
public class ReceiveAccountDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("receive account delegate");
        CustomerResponse customerResponse = (CustomerResponse) delegateExecution.getVariable("customerResponse");

        List<AccountResponse> accountList = customerResponse.getAccountList();

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setData(accountList);
        commonResponse.setStatus(Status.successStatus());

        delegateExecution.setVariable("accountResponses", commonResponse);
    }
}
