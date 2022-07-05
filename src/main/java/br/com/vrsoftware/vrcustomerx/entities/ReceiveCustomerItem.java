package br.com.vrsoftware.vrcustomerx.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "receberclienteitem")
public class ReceiveCustomerItem extends AbstractPersistable<Long> {

    @Column(name = "ID_RECEBERCLIENTE")
    private Long idReceberCliente;

    @Column(name = "ID_SERVICO")
    private Integer idServico;

    @Column(name = "VALORVR")
    private Double valorVR;

    @Column(name = "VALORUNIDADE")
    private Double valorUnidade;

    public Long getIdReceberCliente() {
        return idReceberCliente;
    }

    public void setIdReceberCliente(Long idReceberCliente) {
        this.idReceberCliente = idReceberCliente;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Double getValorVR() {
        return valorVR;
    }

    public void setValorVR(Double valorVR) {
        this.valorVR = valorVR;
    }

    public Double getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(Double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }
}
