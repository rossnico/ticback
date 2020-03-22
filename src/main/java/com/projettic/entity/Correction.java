package com.projettic.entity;

public class Correction {
    int idCorrection;
    int idExercise;
    String textCorrection;

    public int getIdCorrection() {
        return idCorrection;
    }

    public void setIdCorrection(int idCorrection) {
        this.idCorrection = idCorrection;
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

    @Override
    public String toString() {
        return "Correction{" +
                "idCorrection=" + idCorrection +
                ", idExercise=" + idExercise +
                ", textCorrection='" + textCorrection + '\'' +
                '}';
    }
}
