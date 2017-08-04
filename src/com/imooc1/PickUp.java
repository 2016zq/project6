package com.imooc1;

public class PickUp extends Car {
	public PickUp() {}
	public PickUp(int id, String name, double price,int personCapacity,double goodsCapacity) {
		super(id, name, price);
		this.setPersonCapacity(personCapacity);
		this.setGoodsCapacity(goodsCapacity);
	}
	@Override
	public String toString() {
		return super.toString() + "‘ÿ»À:" + getPersonCapacity() + "»À" + "\t" + "‘ÿªı:" + getGoodsCapacity() + "∂÷";
	}
	
}
