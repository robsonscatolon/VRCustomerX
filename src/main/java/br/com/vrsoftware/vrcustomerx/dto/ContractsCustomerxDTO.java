package br.com.vrsoftware.vrcustomerx.dto;

public class ContractsCustomerxDTO {

    private String external_id_client;
    private String description;
    private String start_date;
    private Double contract_value;

    public String getExternal_id_client() {
        return external_id_client;
    }

    public void setExternal_id_client(String external_id_client) {
        this.external_id_client = external_id_client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public Double getContract_value() {
        return contract_value;
    }

    public void setContract_value(Double contract_value) {
        this.contract_value = contract_value;
    }
}
