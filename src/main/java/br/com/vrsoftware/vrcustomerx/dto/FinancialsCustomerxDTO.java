package br.com.vrsoftware.vrcustomerx.dto;

public class FinancialsCustomerxDTO {

    private String external_id_financial;
    private String identifier;
    private String description;
    private String date_issue;
    private String date_due;
    private Double value;
    private String external_id_client;
    private String date_payment;
    private Double discount_value;
    private Double amount_paid;
    private String status;

    public String getExternal_id_financial() {
        return external_id_financial;
    }

    public void setExternal_id_financial(String external_id_financial) {
        this.external_id_financial = external_id_financial;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(String date_issue) {
        this.date_issue = date_issue;
    }

    public String getDate_due() {
        return date_due;
    }

    public void setDate_due(String date_due) {
        this.date_due = date_due;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getExternal_id_client() {
        return external_id_client;
    }

    public void setExternal_id_client(String external_id_client) {
        this.external_id_client = external_id_client;
    }

    public String getDate_payment() {
        return date_payment;
    }

    public void setDate_payment(String date_payment) {
        this.date_payment = date_payment;
    }

    public Double getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(Double discount_value) {
        this.discount_value = discount_value;
    }

    public Double getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(Double amount_paid) {
        this.amount_paid = amount_paid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
