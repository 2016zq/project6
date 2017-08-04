package com.imooc1;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//����Scanner����
		Car[] cars = {new Auto(1,"�µ�A4",500,4),//��̬������ѡ������
					  new Auto(2,"���Դ�6",400,4),
					  new PickUp(3,"Ƥ��ѩ6",450,4,2),
					  new Auto(4,"����",800,20),
					  new Trunk(5,"�ɻ���",400,4),
					  new Trunk(6,"��ά��",1000,20)};
		System.out.println("��ӭʹ�ô���⳵ϵͳ:");
		System.out.println("���Ƿ�Ҫ�⳵:1��    0��");
		//��ʾ���Ķ���,ʹ��foreach
		int judge = input.nextInt();
		do{
			if(judge == 1) {
				System.out.println("���" + "\t" + "��������" + "\t" + "���" + "\t" + "\t����");
				for(Car car:cars) {
					System.out.println(car);
				}
				break;
			}else if(judge == 0){
				System.out.println("ллʹ�ã��ټ���");
				input.close(); 
				System.exit(-1);
				break;
			}
			else{
				System.out.println("������Ϸ�����:");
				judge = input.nextInt();
			}
		}while (judge != 1 || judge != 0);
		
		//�⳵����
		System.out.println("��������Ҫ��ĳ�������:");
		int rentNum = input.nextInt();
		int choices[] = new int[rentNum];//newһ��select���飬װ�����ID��ֵ
		for(int i = 1;i <= rentNum;i++) {
			int chooseId;
			do{System.out.println("�������" + i + "���������:");
			chooseId = input.nextInt();
			}while(chooseId <= 0 || chooseId > cars.length );
		choices[i-1] = chooseId ;
		}
		
		//�⳵����,������۸�Ҫ��
		System.out.println("�������⳵������:");
		int rentDay = input.nextInt();
		System.out.println("�����˵�:");
		System.out.println("�����˵ĳ���:");
		
		//�������Ĳ���
		int sum1 = 0;
		double price1 = 0;
		for(int i = 0;i < choices.length;i++) {//����select��ֵ�����ҵ���Ӧ��car����
			if(cars[choices[i]-1] instanceof Auto || cars[choices[i]-1] instanceof PickUp ) {
				System.out.print(cars[choices[i]-1].getName() + "\t");	
				sum1 = sum1 + cars[choices[i]-1].getPersonCapacity();
				price1 = price1 + cars[choices[i]-1].getPrice();
			}	
		}
		System.out.print("������:" + sum1 + "��");
		System.out.println();
		
		
		System.out.println("���ػ��ĳ���:");
		double sum2 = 0;
		double price2 = 0;
		double price3 = 0;
		for(int i = 0;i < choices.length;i++) {//����select��ֵ�����ҵ���Ӧ��car����
			if(cars[choices[i]-1] instanceof Trunk || cars[choices[i]-1] instanceof PickUp ) {
				System.out.print(cars[choices[i]-1].getName() + "\t");	
				sum2 = sum2 + cars[choices[i]-1].getGoodsCapacity();
				price2 = price2 + cars[choices[i]-1].getPrice();
			}	
		}  
		for(int i = 0;i < choices.length;i++) {//����select��ֵ�����ҵ���Ӧ��car����
			if(cars[choices[i]-1] instanceof PickUp ) {
				price3 = price3 + cars[choices[i]-1].getPrice();
			}	
		}
		System.out.print("���ػ�:" + sum2 + "��");
		System.out.println();
		System.out.println("�⳵�ܼ۸�:" + (price1 + price2 - price3)*rentDay + "Ԫ");
		
	}
}
