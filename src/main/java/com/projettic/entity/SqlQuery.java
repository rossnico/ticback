package com.projettic.entity;


public class SqlQuery {

    private int idExercise;
    private String sqlQuery;

    public SqlQuery(int idExercise, String sqlQuery) {
        this.idExercise = idExercise;
        this.sqlQuery = sqlQuery;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }
    public String getSqlQuery() {
        return sqlQuery;
    }

    @Override
    public String toString() {
        return "SqlQuery{" +
                "idExercise=" + idExercise +
                ", sqlQuery='" + sqlQuery + '\'' +
                '}';
    }
}
