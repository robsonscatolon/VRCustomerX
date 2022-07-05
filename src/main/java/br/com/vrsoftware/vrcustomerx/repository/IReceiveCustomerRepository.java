package br.com.vrsoftware.vrcustomerx.repository;

import br.com.vrsoftware.vrcustomerx.entities.ReceiveCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReceiveCustomerRepository extends JpaRepository<ReceiveCustomer, Long> {
}
