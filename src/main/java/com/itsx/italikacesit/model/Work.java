package com.itsx.italikacesit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "work")
public class Work implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folio")
    private Integer folio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_type_of_work", referencedColumnName = "folio", nullable = false)
    private TypeOfWork typeOfWork;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_mechanic", referencedColumnName = "folio", nullable = false)
    private Mechanic mechanic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_vehicle", referencedColumnName = "plaque", nullable = false)
    private Vehicle vehicle;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "fecha_recibido", nullable = false)
    private Date fechaRecibido;

    @Column(name = "fecha_entrega", nullable = false)
    private Date fechaEntrega;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_client", referencedColumnName = "folio", nullable = false)
    private Client client;

    @Column(name = "issues", nullable = false)
    private String issues;

    public Work(Integer folio, TypeOfWork typeOfWork, Mechanic mechanic, Vehicle vehicle, Double cost, Date fechaRecibido, Date fechaEntrega, Client client, String issues) {
        this.folio = folio;
        this.typeOfWork = typeOfWork;
        this.mechanic = mechanic;
        this.vehicle = vehicle;
        this.cost = cost;
        this.fechaRecibido = fechaRecibido;
        this.fechaEntrega = fechaEntrega;
        this.client = client;
        this.issues = issues;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public TypeOfWork getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(TypeOfWork typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }
}
