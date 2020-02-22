package com.projettic.entity;

import java.io.Serializable;

public class Emp implements Serializable {
    Integer id_emp;
    String nom_emp;

    public Integer getId_emp() {
        return id_emp;	
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    @Override
    public String toString() {
        return "emp{" +
                "id_emp=" + id_emp +
                ", nom_emp='" + nom_emp + '\'' +
                '}';
    }
    //TEST GITHUB
    //Test github from master to rossnicosqdfsdqqfssd
}
