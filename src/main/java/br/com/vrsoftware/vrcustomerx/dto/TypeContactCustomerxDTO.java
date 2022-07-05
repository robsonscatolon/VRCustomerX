package br.com.vrsoftware.vrcustomerx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class TypeContactCustomerxDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String description;
    private String external_id;
    private Boolean status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
