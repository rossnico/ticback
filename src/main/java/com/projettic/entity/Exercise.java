package com.projettic.entity;

public class Exercise {
    private int idExercise;
    private String exerciseText;

    @Override
    public String toString() {
        return "Exercise{" +
                "idExercise=" + idExercise +
                ", exerciseText='" + exerciseText + '\'' +
                ", groupId=" + groupId +
                '}';
    }

    private int groupId;

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
