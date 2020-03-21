package com.projettic.entity;

import java.util.Comparator;

public class Category{
	
	private int idCategory;
	private String nameCategory;
	private int orderCategory;

	@Override
	public String toString() {
		return "Category{" +
				"idCategory=" + idCategory +
				", nameCategory='" + nameCategory + '\'' +
				", orderCategory=" + orderCategory +
				'}';
	}

	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int id) {
		this.idCategory = id;
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
