package com.projettic.entity;

import lombok.Data;

@Data
public class AccountAdvancement {
    private int userId;
    private int nbExercisesDone;
    private double advancementPercentage;
    private int idCategory = 0;
}
