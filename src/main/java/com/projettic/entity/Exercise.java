package com.projettic.entity;

public class Exercise {
    private int idExercise;
    private String exerciseText;
    private String correction;

    public String getExerciseText() {
        return exerciseText;
    }

    public void setExerciseText(String exerciseText) {
        this.exerciseText = exerciseText;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }
}
