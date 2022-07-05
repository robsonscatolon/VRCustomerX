package br.com.vrsoftware.vrcustomerx.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "recebercliente")
public class ReceiveCustomer extends AbstractPersistable<Long> {

    @Column(name="ID_CLIENTE")
    private Integer idCliente;

    @Column(name = "DATA")
    private String data;

    @Column(name="ID_SITUACAORECEBERCLIENTE")
    private Integer idSituacaoReceberCliente;

    @Column(name="DATAPROCESSAMENTO")
    private String dataProcessamento;

    @Column(name="DATAVENCIMENTO")
    private String dataVencimento;

    @Column(name="VALORJUROS")
    private Double valorJuros;

    @Column(name="PERCENTUALJUROS")
    private Double percentualJuros;

    @Column(name="DATAPAGAMENTO")
    private String dataPagamento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recebercliente")
    @JoinColumn(name = "id_recebercliente")
    private List<ReceiveCustomerItem> items;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getIdSituacaoReceberCliente() {
        return idSituacaoReceberCliente;
    }

    public void setIdSituacaoReceberCliente(Integer idSituacaoReceberCliente) {
        this.idSituacaoReceberCliente = idSituacaoReceberCliente;
    }

    public String getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(String dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(Double valorJuros) {
        this.valorJuros = valorJuros;
    }

    public Double getPercentualJuros() {
        return percentualJuros;
    }

    public void setPercentualJuros(Double percentualJuros) {
        this.percentualJuros = percentualJuros;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public List<ReceiveCustomerItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiveCustomerItem> items) {
        this.items = items;
    }
}
