package com.itsx.italikacesit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Esta clase se encarga de mapear la tabla {@code TypeOfWork} de la
 * base de datos {@code italikadb}. La estructura de esta clase es la de
 * un POJO en la cual se definen los atributos con sus respectivos
 * getters y setters.
 * <p>
 * Cada atributo representa un campo de la tabla de la base de dadtos.
 * <p>
 * La clase {@code TypeOfWork} implementa {@link Serializable} para que sea
 * transmitida de forma remota.
 * <p>
 * Esta nueva entidad define 2 atributos:
 * <pre>
 *     folio
 *     nameOfWork
 * </pre>
 *
 * @author Alexis Vazquez
 * @see java.io.Serializable
 * @since   11
 */
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
