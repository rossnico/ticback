package com.projettic.entity;


public class SqlQuery {
    private String sqlQuery;


    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    @Override
    public String toString() {
        return this.sqlQuery;
    }
}
