package com.imooc1;

public class Car {
	private int id;
	private String name;
	private double price;
	private int  personCapacity;
	private double goodsCapacity;
	public Car() {}
	public Car(int id,String name,double price) {
		this.id = id;
		this.name  = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPersonCapacity() {
		return personCapacity;
	}
	public void setPersonCapacity(int personCapacity) {
		this.personCapacity = personCapacity;
	}
	public double getGoodsCapacity() {
		return goodsCapacity;
	}
	public void setGoodsCapacity(double goodsCapacity) {
		this.goodsCapacity = goodsCapacity;
	}
	@Override
	public String toString() {
		return  id + "\t " + name + "\t" + price + "ิช/ฬ์" + "\t";
	}
	
}
