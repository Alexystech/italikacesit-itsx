package com.itsx.italikacesit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "type_of_work")
public class TypeOfWork implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folio")
    private Integer folio;

    @Column(name = "name_of_work", length = 30, nullable = false)
    private String nameOfWork;

    public TypeOfWork(Integer folio, String nameOfWork) {
        this.folio = folio;
        this.nameOfWork = nameOfWork;
    }

    public TypeOfWork() {}

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getNameOfWork() {
        return nameOfWork;
    }

    public void setNameOfWork(String nameOfService) {
        this.nameOfWork = nameOfService;
    }
}
