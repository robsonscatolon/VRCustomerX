package br.com.vrsoftware.vrcustomerx.service;

import br.com.vrsoftware.vrcustomerx.entities.Customer;
import br.com.vrsoftware.vrcustomerx.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

}
