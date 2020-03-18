package com.projettic.entity;

public class Correction {
    int id;
    int idExercise;
    String textCorrection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public String getTextCorrection() {
        return textCorrection;
    }

    public void setTextCorrection(String textCorrection) {
        this.textCorrection = textCorrection;
    }
}
