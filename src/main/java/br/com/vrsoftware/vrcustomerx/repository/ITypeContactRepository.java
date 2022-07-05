package br.com.vrsoftware.vrcustomerx.repository;

import br.com.vrsoftware.vrcustomerx.entities.Customer;
import br.com.vrsoftware.vrcustomerx.entities.TypeContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeContactRepository extends JpaRepository<TypeContact, Long> {
}
