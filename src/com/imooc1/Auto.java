package com.imooc1;

public class Auto extends Car {
	public Auto() {}
	public Auto(int id, String name, double price,int personCapacity) {
		super(id, name, price);
		this.setPersonCapacity(personCapacity);
	}

	@Override
	public String toString() {
		return super.toString() + "‘ÿ»À:" + getPersonCapacity() + "»À";
	}
	

}
