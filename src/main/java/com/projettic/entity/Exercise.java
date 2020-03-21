package com.projettic.entity;

public class Exercise {
    private int idExercise;
    private String textExercise;
    private String idCategory;

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getTextExercise() {
        return textExercise;
    }

    public void setTextExercise(String textExercise) {
        this.textExercise = textExercise;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "idExercise=" + idExercise +
                ", exerciseText='" + textExercise + '\'' +
                ", idCategory='" + idCategory + '\'' +
                '}';
    }
}
