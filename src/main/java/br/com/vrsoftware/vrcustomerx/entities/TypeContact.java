package br.com.vrsoftware.vrcustomerx.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipocontato")
public class TypeContact extends AbstractPersistable<Long> {

    @Column(name = "DESCRICAO")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
