package br.com.vrsoftware.vrcustomerx.dto;

public class ResponseErrorEntityDTO {

    private String message;
    private String error;

    public ResponseErrorEntityDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ResponseErrorEntityDTO(String error) {
        this.message = "An error occurred.";
        this.error = error;
    }
}
