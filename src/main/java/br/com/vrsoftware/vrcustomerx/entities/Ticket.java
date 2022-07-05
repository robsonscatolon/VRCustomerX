package br.com.vrsoftware.vrcustomerx.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "boleto")
public class Ticket extends AbstractPersistable<Long> {

    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    private Double valor;

    private String dataVencimento;

    @Column(name = "ID_SITUACAOBOLETO")
    private Integer idSituacaoBoleto;

    private Long nossoNumero;

    private Integer numeroDocumento;

    private String dataEmissao;

    private String dataProcessamento;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Integer getIdSituacaoBoleto() {
        return idSituacaoBoleto;
    }

    public void setIdSituacaoBoleto(Integer idSituacaoBoleto) {
        this.idSituacaoBoleto = idSituacaoBoleto;
    }

    public Long getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(Long nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(String dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }
}
