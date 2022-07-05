package br.com.vrsoftware.vrcustomerx.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICO")
public class Service extends AbstractPersistable<Long> {

    @Column(name = "descricao")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
