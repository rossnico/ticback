package com.projettic.entity;


public class SqlQuery {
    public String getSqlQuery() {
        return sqlQuery;
    }

    private String sqlQuery;


    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    @Override
    public String toString() {
        return this.sqlQuery;
    }
}
