package com.itsx.italikacesit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "administrator")
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folio")
    private Integer folio;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "mother_last_name", length = 20, nullable = false)
    private String motherLastName;

    @Column(name = "user_name", length = 20, nullable = false)
    private String userName;

    @Column(name = "EMail", length = 40, nullable = false)
    private String eMail;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "cellphone", length = 10, nullable = false)
    private String cellphone;

    public Administrator(Integer folio, String name, String lastName, String motherLastName, String userName, String eMail, String password, String cellphone) {
        this.folio = folio;
        this.name = name;
        this.lastName = lastName;
        this.motherLastName = motherLastName;
        this.userName = userName;
        this.eMail = eMail;
        this.password = password;
        this.cellphone = cellphone;
    }

    public Administrator() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
