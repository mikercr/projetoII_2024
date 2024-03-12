package com.ipvc.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @Column(name = "codproduto", nullable = false)
    private Long id;

    @Column(name = "nome", length = 25)
    private String nome;

    @Column(name = "price", precision = 12, scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "produto")
    private Set<LinhaFatura> linhaFaturas = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<LinhaFatura> getLinhaFaturas() {
        return linhaFaturas;
    }

    public void setLinhaFaturas(Set<LinhaFatura> linhaFaturas) {
        this.linhaFaturas = linhaFaturas;
    }

}