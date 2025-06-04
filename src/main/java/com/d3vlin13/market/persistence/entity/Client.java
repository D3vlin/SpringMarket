package com.d3vlin13.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idClient;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String lastnames;

    @Column(name = "celular")
    private Long cellphone;

    @Column(name = "direccion")
    private String address;

    @Column(name="correo_electronico")
    private String email;

    @OneToMany(mappedBy = "idPurchase")
    private List<Purchase> purchases;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
