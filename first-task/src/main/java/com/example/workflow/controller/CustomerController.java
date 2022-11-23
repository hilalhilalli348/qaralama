package com.example.workflow.controller;

import com.example.workflow.service.CamundaStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/customers")
public class CustomerController {

    private final CamundaStart camundaStart;

    @Autowired
    public CustomerController(CamundaStart camundaStart) {
        this.camundaStart = camundaStart;
    }


    @GetMapping(path = "{id}")
    public void getCustomer(@PathVariable("id") int id){
        camundaStart.start(id);
    }





}
