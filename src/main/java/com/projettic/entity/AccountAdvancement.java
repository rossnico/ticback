package com.projettic.entity;

public class AccountAdvancement {
	private int userId;
	private int nbExercisesDone;
	private double advancementPercentage;
	private int idCategory = 0 ;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNbExercisesDone() {
		return nbExercisesDone;
	}
	public void setNbExercisesDone(int nbExercisesDone) {
		this.nbExercisesDone = nbExercisesDone;
	}

	public double getAdvancementPercentage() {
		return advancementPercentage;
	}
	public void setAdvancementPercentage(double advancementPercentage) {
		this.advancementPercentage = advancementPercentage;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	
}
