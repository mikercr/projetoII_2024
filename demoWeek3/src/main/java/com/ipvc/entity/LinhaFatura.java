package com.ipvc.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "\"LinhaFatura\"")
public class LinhaFatura {
    @EmbeddedId
    private LinhaFaturaId id;

    @MapsId("numFatura")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"numFatura\"", nullable = false)
    private Fatura fatura;

    @MapsId("idProduto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"IdProduto\"", nullable = false)
    private Produto produto;

    @Column(name = "quantidade", nullable = false, precision = 8, scale = 2)
    private BigDecimal quantidade;

    public LinhaFaturaId getId() {
        return id;
    }

    public void setId(LinhaFaturaId id) {
        this.id = id;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

}