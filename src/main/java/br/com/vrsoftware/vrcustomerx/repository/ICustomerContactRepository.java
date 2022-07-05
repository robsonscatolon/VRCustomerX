package br.com.vrsoftware.vrcustomerx.repository;

import br.com.vrsoftware.vrcustomerx.entities.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerContactRepository extends JpaRepository<CustomerContact, Long> {

    @Query("SELECT c FROM CustomerContact c WHERE c.id_cliente = ?1")
    List<CustomerContact> findAllContactsByClientId(Integer idClient);

}
