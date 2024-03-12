package com.ipvc.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Fatura\"")
public class Fatura {
    @Id
    @Column(name = "\"numFatura\"", nullable = false)
    private Long numFatura;

    @Column(name = "\"totalFatura\"", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalFatura;

    @Column(name = "\"dataFatura\"", nullable = false)
    private LocalDate dataFatura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"IdCliente\"", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "fatura")
    private Set<LinhaFatura> linhaFaturas = new LinkedHashSet<>();

    public Long getNumFatura() {
        return numFatura;
    }

    public void setNumFatura(Long numFatura) {
        this.numFatura = numFatura;
    }

    public BigDecimal getTotalFatura() {
        return totalFatura;
    }

    public void setTotalFatura(BigDecimal totalFatura) {
        this.totalFatura = totalFatura;
    }

    public LocalDate getDataFatura() {
        return dataFatura;
    }

    public void setDataFatura(LocalDate dataFatura) {
        this.dataFatura = dataFatura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<LinhaFatura> getLinhaFaturas() {
        return linhaFaturas;
    }

    public void setLinhaFaturas(Set<LinhaFatura> linhaFaturas) {
        this.linhaFaturas = linhaFaturas;
    }

}