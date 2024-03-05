package entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Cliente\"")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdCliente\"", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "\"postalCode\"", length = 10)
    private String postalCode;

    @Column(name = "nif", length = 10)
    private String nif;

    @OneToMany(mappedBy = "idCliente")
    private Set<Fatura> faturas = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Set<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(Set<Fatura> faturas) {
        this.faturas = faturas;
    }

}