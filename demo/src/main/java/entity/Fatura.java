package entity;

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
    private Long id;

    @Column(name = "\"totalFatura\"", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalFatura;

    @Column(name = "\"dataFatura\"", nullable = false)
    private LocalDate dataFatura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"IdCliente\"", nullable = false)
    private Cliente idCliente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

}