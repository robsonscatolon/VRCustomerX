package br.com.vrsoftware.vrcustomerx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ClientContactCustomerxDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String email;
    private String name;
    private Long type_contact_id;
    private String external_id_client;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ClientContactPhoneCustomerxDTO> phones;

    public ClientContactCustomerxDTO() {
    }

    public ClientContactCustomerxDTO(String email, String name, Long type_contact_id, String external_id_client, List<ClientContactPhoneCustomerxDTO> phones) {
        this.email = email;
        this.name = name;
        this.type_contact_id = type_contact_id;
        this.external_id_client = external_id_client;
        this.phones = phones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getType_contact_id() {
        return type_contact_id;
    }

    public void setType_contact_id(Long type_contact_id) {
        this.type_contact_id = type_contact_id;
    }

    public String getExternal_id_client() {
        return external_id_client;
    }

    public void setExternal_id_client(String external_id_client) {
        this.external_id_client = external_id_client;
    }

    public List<ClientContactPhoneCustomerxDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<ClientContactPhoneCustomerxDTO> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "ClientContactCustomerxDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", type_contact_id=" + type_contact_id +
                ", external_id_client='" + external_id_client + '\'' +
                ", phones=" + phones +
                '}';
    }
}
