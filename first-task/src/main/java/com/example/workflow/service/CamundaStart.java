package com.example.workflow.service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamundaStart {
    private RuntimeService runtimeService;

    @Autowired
    public CamundaStart(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }


    public void start(int id) {
        ProcessInstanceWithVariables customerbpm = runtimeService.createProcessInstanceByKey("customerbpm")
                .setVariable("customer_id", id)
                .executeWithVariablesInReturn();
    }
}
