package com.projettic.entity;

public class Exercise {
    private int idExercise;
    private String exerciseText;
    private String exerciseCorrection;

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

    public String getExerciseCorrection() {
        return exerciseCorrection;
    }

    public void setExerciseCorrection(String exerciseCorrection) {
        this.exerciseCorrection = exerciseCorrection;
    }

}
