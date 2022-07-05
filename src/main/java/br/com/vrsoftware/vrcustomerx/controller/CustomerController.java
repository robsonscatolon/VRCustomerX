package br.com.vrsoftware.vrcustomerx.controller;

import br.com.vrsoftware.vrcustomerx.entities.Customer;
import br.com.vrsoftware.vrcustomerx.service.CreateCustomerService;
import br.com.vrsoftware.vrcustomerx.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController{

    @Autowired
    CustomerService customerService;

    @Autowired
    CreateCustomerService createCustomerService;

    @GetMapping
    public List<Customer> get(){
        return customerService.getAll();
    }

    @GetMapping("/exists")
    public Boolean exists() throws Exception{
        return createCustomerService.execute(347);
    }
}