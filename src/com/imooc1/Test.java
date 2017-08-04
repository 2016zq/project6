package com.imooc1;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//创建Scanner对象
		Car[] cars = {new Auto(1,"奥迪A4",500,4),//多态，创建选车对象
					  new Auto(2,"马自达6",400,4),
					  new PickUp(3,"皮卡雪6",450,4,2),
					  new Auto(4,"金龙",800,20),
					  new Trunk(5,"松花江",400,4),
					  new Trunk(6,"依维柯",1000,20)};
		System.out.println("欢迎使用答答租车系统:");
		System.out.println("您是否要租车:1是    0否");
		//显示车的对象,使用foreach
		int judge = input.nextInt();
		do{
			if(judge == 1) {
				System.out.println("序号" + "\t" + "汽车名称" + "\t" + "租金" + "\t" + "\t容量");
				for(Car car:cars) {
					System.out.println(car);
				}
				break;
			}else if(judge == 0){
				System.out.println("谢谢使用！再见！");
				input.close(); 
				System.exit(-1);
				break;
			}
			else{
				System.out.println("请输入合法数据:");
				judge = input.nextInt();
			}
		}while (judge != 1 || judge != 0);
		
		//租车数量
		System.out.println("请输入您要租的车的数量:");
		int rentNum = input.nextInt();
		int choices[] = new int[rentNum];//new一个select数组，装输入的ID数值
		for(int i = 1;i <= rentNum;i++) {
			int chooseId;
			do{System.out.println("请输入第" + i + "辆车的序号:");
			chooseId = input.nextInt();
			}while(chooseId <= 0 || chooseId > cars.length );
		choices[i-1] = chooseId ;
		}
		
		//租车天数,后面算价格要用
		System.out.println("请输入租车的天数:");
		int rentDay = input.nextInt();
		System.out.println("您的账单:");
		System.out.println("可载人的车有:");
		
		//这里做的不好
		int sum1 = 0;
		double price1 = 0;
		for(int i = 0;i < choices.length;i++) {//遍历select的值，并找到相应的car对象
			if(cars[choices[i]-1] instanceof Auto || cars[choices[i]-1] instanceof PickUp ) {
				System.out.print(cars[choices[i]-1].getName() + "\t");	
				sum1 = sum1 + cars[choices[i]-1].getPersonCapacity();
				price1 = price1 + cars[choices[i]-1].getPrice();
			}	
		}
		System.out.print("共载人:" + sum1 + "人");
		System.out.println();
		
		
		System.out.println("可载货的车有:");
		double sum2 = 0;
		double price2 = 0;
		double price3 = 0;
		for(int i = 0;i < choices.length;i++) {//遍历select的值，并找到相应的car对象
			if(cars[choices[i]-1] instanceof Trunk || cars[choices[i]-1] instanceof PickUp ) {
				System.out.print(cars[choices[i]-1].getName() + "\t");	
				sum2 = sum2 + cars[choices[i]-1].getGoodsCapacity();
				price2 = price2 + cars[choices[i]-1].getPrice();
			}	
		}  
		for(int i = 0;i < choices.length;i++) {//遍历select的值，并找到相应的car对象
			if(cars[choices[i]-1] instanceof PickUp ) {
				price3 = price3 + cars[choices[i]-1].getPrice();
			}	
		}
		System.out.print("共载货:" + sum2 + "吨");
		System.out.println();
		System.out.println("租车总价格:" + (price1 + price2 - price3)*rentDay + "元");
		
	}
}
