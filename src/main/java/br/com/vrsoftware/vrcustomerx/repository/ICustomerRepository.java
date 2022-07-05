package br.com.vrsoftware.vrcustomerx.repository;

import br.com.vrsoftware.vrcustomerx.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
