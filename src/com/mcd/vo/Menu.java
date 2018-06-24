package com.mcd.vo;

public class Menu {
	private int foodNumber;
	private String name;
	private int price;
	
	public Menu() {
		super();
	}
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public int getFoodNumber() {
		return foodNumber;
	}
	public void setFoodNumber(int foodNumber) {
		this.foodNumber = foodNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
