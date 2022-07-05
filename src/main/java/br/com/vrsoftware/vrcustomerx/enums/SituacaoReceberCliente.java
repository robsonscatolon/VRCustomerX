package br.com.vrsoftware.vrcustomerx.enums;

public enum SituacaoReceberCliente {
    ABERTO(1, "ABERTO"),
    PAGO(2, "PAGO"),
    CANCELADO(3, "CANCELADO");

    private Integer id;
    private String description;

    private SituacaoReceberCliente(Integer id, String description){
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
