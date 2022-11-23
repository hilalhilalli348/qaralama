package com.example.workflow.delegate;

import com.example.workflow.dao.CustomerDAO;
import com.example.workflow.dto.CustomerResponse;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("scanCustomerDelegate")
public class ScanCustomerDelegate implements JavaDelegate {
    private final CustomerDAO customerDAO;

    public ScanCustomerDelegate(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int id = (int) delegateExecution.getVariable("customer_id");

        CustomerResponse customer = customerDAO.getCustomer(id);

        if (customer!=null){
            delegateExecution.setVariable("customerResponse",customer);
            delegateExecution.setVariable("customerExsist",true);
        }else {
            delegateExecution.setVariable("customerExsist",false);
        }

    }
}
