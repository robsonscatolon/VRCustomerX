package br.com.vrsoftware.vrcustomerx.service;

import br.com.vrsoftware.vrcustomerx.dto.ContractsCustomerxDTO;
import br.com.vrsoftware.vrcustomerx.entities.Customer;
import br.com.vrsoftware.vrcustomerx.entities.CustomerMonthlyPayment;
import br.com.vrsoftware.vrcustomerx.repository.ICustomerContactRepository;
import br.com.vrsoftware.vrcustomerx.repository.ICustomerMonthlyPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExportCustomerContractsService {

    @Autowired
    private ICustomerMonthlyPaymentRepository customerMonthlyPaymentRepository;

    public List<ContractsCustomerxDTO> execute(Integer idCustomer) throws Exception{
        List<CustomerMonthlyPayment> monthlyPayments = customerMonthlyPaymentRepository.findAllContractsByCustomerId(idCustomer);

        if(monthlyPayments.isEmpty()){
            throw new Exception("Contracts not found for customer.");
        }

        List<ContractsCustomerxDTO> contracts = new ArrayList<>();

        for(CustomerMonthlyPayment mPayment : monthlyPayments)
    }

}
