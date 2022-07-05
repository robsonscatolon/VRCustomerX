package br.com.vrsoftware.vrcustomerx.repository;

import br.com.vrsoftware.vrcustomerx.entities.CustomerContact;
import br.com.vrsoftware.vrcustomerx.entities.CustomerMonthlyPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerMonthlyPaymentRepository extends JpaRepository<CustomerMonthlyPayment, Long> {

    @Query("SELECT c FROM CustomerMonthlyPayment c WHERE c.id_cliente = ?1")
    List<CustomerMonthlyPayment> findAllContractsByCustomerId(Integer idCustomer);
}
