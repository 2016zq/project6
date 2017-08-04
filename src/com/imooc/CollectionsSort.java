package com.imooc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 1��ͨ��Collections.sort()��������Integer���͵�List��������
 * 2����String���͵ķ���List����
 * 3�����������͵ķ���List������StudentΪ��
 * @author Qiong
 *
 */
public class CollectionsSort {
	public void intSort() {
		List<Integer> integerList = new ArrayList<Integer>();
		Random random = new Random();
		Integer k;
		for(int i = 0;i < 10;i++) {
			//ѭ����֤����������ظ�
			do {
				k = random.nextInt(100);
			}while(integerList.contains(k));
			integerList.add(k);
			System.out.println("�ɹ����Ԫ��:" + k);
		}
		System.out.println("------����ǰ��˳��------");
		for(Integer in : integerList) {
			System.out.println("�������:" + in);
		}
		System.out.println("--------������˳��--------");
		Collections.sort(integerList);
		for(Integer in : integerList) {
			System.out.println("�������:" + in);
		}
	}
	/**
	 * 2.��String���͵�List��������
	 * ����String���͵�List�����ʮ������ַ�����
	 * ÿ���ַ����ĳ���Ϊ10���ڵ����������
	 * ÿ���ַ�����ÿ���ַ�����������ɵ��ַ����ַ������ظ�
	 * ÿ��������ɵ��ַ��������ظ�
	 * ����sort�������ٴ����������˳��
	 * @param args
	 */
	public void stringSort() {
		String string = "0123456789abcdefghijklmnopqrstuvwxyz"
						+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		List<String> stringList = new ArrayList<String>();
		Random random = new Random();
		for(int i = 0;i < 10;i++) {//�涨����ʮ���ַ���
			StringBuilder sb = new StringBuilder();//����StringBuilder�������ַ�������ַ�
			int k = random.nextInt(10);//ÿ���ַ����ĳ���Ϊʮ���ڵ������
			for(int j = 0;j <= k;j++ ) {
				int id = random.nextInt(string.length());
				sb.append(string.charAt(id));
				}
			String st = sb.toString();//��StringBuilderͨ��toString()����תΪString����
			stringList.add(st);
			System.out.println("�ɹ������ַ���:" + st);
		}
		System.out.println("----------����ǰ---------");
		for(String st : stringList) {
			System.out.println(st);
		}
		System.out.println("-----------�����----------");
		Collections.sort(stringList);
		for(String st : stringList) {
			System.out.println(st);
		}	
	}
	/**
	 * 3�����������ͷ��͵�List����������StudentΪ��
	 * �����������ظ���1000���ڵ������������Ϊѧ��ID
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
		System.out.println("----------����ǰ---------");
		for(Student stu : students) {
			System.out.println("ѧ��:" + stu.getId() + " " + stu.getName());
		}
		/*����ѧ��ID����ͨ��Comparable�ӿ�*/
		Collections.sort(students);
		System.out.println("----------����ID�����----------");
		for(Student stu : students) {
			System.out.println("ѧ��:" + stu.getId() + " " + stu.getName());
		}
		/*����ѧ����������ͨ��Comparable�ӿ�*/
		Collections.sort(students, new StudentComparator());
		System.out.println("----------�������������----------");
		for(Student stu : students) {
			System.out.println("ѧ��:" + stu.getId() + " " + stu.getName());
		}
	}
	public static void main(String[] args) {
		CollectionsSort cs = new CollectionsSort();
		cs.intSort();
		cs.stringSort();
		cs.studentSort();

	}

}
