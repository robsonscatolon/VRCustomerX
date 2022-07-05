package br.com.vrsoftware.vrcustomerx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ClientCustomerxDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String external_id_client;
    private String email;
    private String company_name;
    private String trading_name;
    private String cnpj_cpf;
    private String ie_rg;
    private String date_register;
    private String cep;
    private String country;
    private String state;
    private String city;
    private String street;
    private String district;
    private Integer number;
    private String complement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExternal_id_client() {
        return external_id_client;
    }

    public void setExternal_id_client(String external_id_client) {
        this.external_id_client = external_id_client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTrading_name() {
        return trading_name;
    }

    public void setTrading_name(String trading_name) {
        this.trading_name = trading_name;
    }

    public String getCnpj_cpf() {
        return cnpj_cpf;
    }

    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    public String getIe_rg() {
        return ie_rg;
    }

    public void setIe_rg(String ie_rg) {
        this.ie_rg = ie_rg;
    }

    public String getDate_register() {
        return date_register;
    }

    public void setDate_register(String date_register) {
        this.date_register = date_register;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return "ClientCustomerxDTO{" +
                "external_id_client='" + external_id_client + '\'' +
                ", email='" + email + '\'' +
                ", company_name='" + company_name + '\'' +
                ", trading_name='" + trading_name + '\'' +
                ", cnpj_cpf='" + cnpj_cpf + '\'' +
                ", ie_rg='" + ie_rg + '\'' +
                ", date_register='" + date_register + '\'' +
                ", cep='" + cep + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", number=" + number +
                ", complement='" + complement + '\'' +
                '}';
    }
}
