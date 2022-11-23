package com.example.workflow.controller;

import com.example.workflow.dto.CommonResponse;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/customers")
public class CustomerController {

    private final RuntimeService runtimeService;

    public CustomerController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }


    @GetMapping(path = "{id}")
    public ResponseEntity<?> customer(@PathVariable("id") int id) {

        ProcessInstanceWithVariables processInstanceWithVariables =
                runtimeService.createProcessInstanceByKey("customerbpm")
                .setVariable("customer_id", id)
                .executeWithVariablesInReturn();

        // gozleme olur.
        VariableMap variables = processInstanceWithVariables.getVariables();

        CommonResponse accountResponses = variables.getValue("accountResponses", CommonResponse.class);
        return ResponseEntity.ok(accountResponses);


    }


}
