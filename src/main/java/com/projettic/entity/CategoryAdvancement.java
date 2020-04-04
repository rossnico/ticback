package com.projettic.entity;

public class CategoryAdvancement extends Category{
	private int nbTotal;
	private int nbDone;
	
	public CategoryAdvancement() {
		super();
	}

	public int getNbTotal() {
		return nbTotal;
	}

	public void setNbTotal(int nbTotal) {
		this.nbTotal = nbTotal;
	}

	public int getNbDone() {
		return nbDone;
	}

	public void setNbDone(int nbDone) {
		this.nbDone = nbDone;
	}

	@Override
	public String toString() {
		return "CategoryAdvancement [nbTotal=" + nbTotal + ", nbDone=" + nbDone + "]";
	}
	
}
