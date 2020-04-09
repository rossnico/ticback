package com.projettic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SqlQuery {

    private int idExercise;
    private String sqlQuery;


}
