package br.com.vrsoftware.vrcustomerx.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="cliente")
public class Customer  extends AbstractPersistable<Long> {

    @Column(name="RAZAOSOCIAL")
    private String razaosocial;

    @Column(name = "NOMEFANTASIA")
    private String nomeFantasia;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name="NUMERO")
    private Integer numero;

    @Column(name = "cep")
    private Long cep;

    @Column(name="EMAIL")
    private String email;

    @Column(name = "CNPJ")
    private Long cnpj;

    @Column(name="datacadastro")
    private String dataCadastro;

    @Column(name="INSCRICAOESTADUAL")
    private String inscricaoEstadual;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_MUNICIPIO", nullable = false)
    private City city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_ESTADO", nullable = false)
    private State state;

    public String getRazaosocial() {
        return razaosocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public City getMunicipio() {
        return city;
    }

    public void setMunicipio(City city) {
        this.city = city;
    }

    public State getEstado() {
        return state;
    }

    public void setEstado(State state) {
        this.state = state;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}
