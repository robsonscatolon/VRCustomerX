package br.com.vrsoftware.vrcustomerx.service;

import br.com.vrsoftware.vrcustomerx.entities.Customer;
import br.com.vrsoftware.vrcustomerx.repository.ICustomerRepository;
import br.com.vrsoftware.vrcustomerx.service.api.CustomerApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    CustomerApiService customerApiService;

    public Boolean execute(Integer idCustomer) throws Exception {

        Optional<Customer> customer = customerRepository.findById(idCustomer.longValue());

        if (!customer.isPresent()) {
            throw new Exception("Customer " + idCustomer + " not found in database!");
        }

        System.out.println(new ObjectMapper().writeValueAsString(customer.get()));

        boolean exists = customerApiService.findByExternalId(idCustomer);

        if (!exists) {
            return customerApiService.create(customer.get());
        } else {
            return customerApiService.update(customer.get());
        }

    }
}
