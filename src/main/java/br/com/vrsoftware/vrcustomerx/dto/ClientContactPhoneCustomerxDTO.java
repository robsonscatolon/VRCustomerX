package br.com.vrsoftware.vrcustomerx.dto;

public class ClientContactPhoneCustomerxDTO {

    private String number;
    private Boolean is_default;

    public ClientContactPhoneCustomerxDTO() {
    }

    public ClientContactPhoneCustomerxDTO(String number, Boolean is_default) {
        this.number = number;
        this.is_default = is_default;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public void setIs_default(Boolean is_default) {
        this.is_default = is_default;
    }

    @Override
    public String toString() {
        return "ClientContactPhoneCustomerxDTO{" +
                "number='" + number + '\'' +
                ", is_default=" + is_default +
                '}';
    }
}
