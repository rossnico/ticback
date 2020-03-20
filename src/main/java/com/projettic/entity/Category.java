package com.projettic.entity;

public class Category {
	
	private int idCategory;
	private String nameCategory;
	private int orderCategory;
	
	@Override
	public String toString() {
		return "Category{" +
                "idCategory=" + idCategory +
                ", nameCategory='" + nameCategory +
                '}';
	}
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public int getOrderCategory() {
		return orderCategory;
	}

	public void setOrderCategory(int orderCategory) {
		this.orderCategory = orderCategory;
	}
	
	
	
	
	
	
}
