package com.imooc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 1、通过Collections.sort()方法，对Integer泛型的List进行排序
 * 2、对String类型的泛型List排序
 * 3、对其他类型的泛型List排序，以Student为例
 * @author Qiong
 *
 */
public class CollectionsSort {
	public void intSort() {
		List<Integer> integerList = new ArrayList<Integer>();
		Random random = new Random();
		Integer k;
		for(int i = 0;i < 10;i++) {
			//循环保证随机整数不重复
			do {
				k = random.nextInt(100);
			}while(integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加元素:" + k);
		}
		System.out.println("------排序前的顺序------");
		for(Integer in : integerList) {
			System.out.println("随机整数:" + in);
		}
		System.out.println("--------排序后的顺序--------");
		Collections.sort(integerList);
		for(Integer in : integerList) {
			System.out.println("随机整数:" + in);
		}
	}
	/**
	 * 2.对String泛型的List进行排序；
	 * 创建String泛型的List，添加十条随机字符串；
	 * 每条字符串的长度为10以内的随机整数；
	 * 每条字符串的每个字符都是随机生成的字符，字符可以重复
	 * 每条随机生成的字符串不可重复
	 * 调用sort方法，再次输出排序后的顺序
	 * @param args
	 */
	public void stringSort() {
		String string = "0123456789abcdefghijklmnopqrstuvwxyz"
						+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		List<String> stringList = new ArrayList<String>();
		Random random = new Random();
		for(int i = 0;i < 10;i++) {//规定生成十个字符串
			StringBuilder sb = new StringBuilder();//创建StringBuilder方便在字符后添加字符
			int k = random.nextInt(10);//每个字符串的长度为十以内的随机数
			for(int j = 0;j <= k;j++ ) {
				int id = random.nextInt(string.length());
				sb.append(string.charAt(id));
				}
			String st = sb.toString();//将StringBuilder通过toString()方法转为String类型
			stringList.add(st);
			System.out.println("成功生成字符串:" + st);
		}
		System.out.println("----------排序前---------");
		for(String st : stringList) {
			System.out.println(st);
		}
		System.out.println("-----------排序后----------");
		Collections.sort(stringList);
		for(String st : stringList) {
			System.out.println(st);
		}	
	}
	/**
	 * 3、对其他类型泛型的List进行排序，以Student为例
	 * 生成三个不重复的1000以内的随机正整数作为学生ID
	 */
	public void studentSort() {
		List<Student> students = new ArrayList<Student>();
		List<String> string = new ArrayList<String>();
		Random random = new Random();
		String id;
		for(int i = 0; i < 3;i++) {
			do {
			 id = random.nextInt(1000) + "";
			}while(string.contains(id));
			string.add(id);
		}
		Student stu1 = new Student(string.get(0),"Tom");
		students.add(stu1);
		Student stu2 = new Student(string.get(1),"Jack");
		students.add(stu2);
		Student stu3 = new Student(string.get(2),"Piter");
		students.add(stu3);
		System.out.println("----------排序前---------");
		for(Student stu : students) {
			System.out.println("学生:" + stu.getId() + " " + stu.getName());
		}
		/*按照学生ID排序，通过Comparable接口*/
		Collections.sort(students);
		System.out.println("----------按照ID排序后----------");
		for(Student stu : students) {
			System.out.println("学生:" + stu.getId() + " " + stu.getName());
		}
		/*按照学生姓名排序，通过Comparable接口*/
		Collections.sort(students, new StudentComparator());
		System.out.println("----------按照姓名排序后----------");
		for(Student stu : students) {
			System.out.println("学生:" + stu.getId() + " " + stu.getName());
		}
	}
	public static void main(String[] args) {
		CollectionsSort cs = new CollectionsSort();
		cs.intSort();
		cs.stringSort();
		cs.studentSort();

	}

}
