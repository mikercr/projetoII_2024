package com.ipvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinhaFaturaId implements Serializable {
    private static final long serialVersionUID = -2143340670968451152L;
    @Column(name = "\"numFatura\"", nullable = false)
    private Long numFatura;

    @Column(name = "\"IdProduto\"", nullable = false)
    private Long idProduto;

    public Long getNumFatura() {
        return numFatura;
    }

    public void setNumFatura(Long numFatura) {
        this.numFatura = numFatura;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LinhaFaturaId entity = (LinhaFaturaId) o;
        return Objects.equals(this.idProduto, entity.idProduto) &&
                Objects.equals(this.numFatura, entity.numFatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, numFatura);
    }

}