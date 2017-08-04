package com.imooc1;

public class Trunk extends Car {
	public Trunk() {}
	public Trunk(int id, String name, double price,double goodsCapacity) {
		super(id, name, price);
		this.setGoodsCapacity(goodsCapacity);
	}
	@Override
	public String toString() {
		return super.toString() + "‘ÿªı:" + getGoodsCapacity() + "∂÷";
	}
	
}
