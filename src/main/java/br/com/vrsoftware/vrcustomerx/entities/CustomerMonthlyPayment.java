package br.com.vrsoftware.vrcustomerx.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "clientemensalidade")
public class CustomerMonthlyPayment extends AbstractPersistable<Long> {

    @Column(name = "ID_CLIENTE")
    private Integer idCustomer;

    @Column(name = "VALORVR")
    private Double amountVR;

    @Column(name = "VALORUNIDADE")
    private Double amountUnity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_SERVICO", nullable = false)
    private Service service;
}
