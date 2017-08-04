package com.imooc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SetTest {
	static Scanner console = new Scanner(System.in);
	public List<Course> selectCourse = new ArrayList<Course>();
	/**
	 * ���ӿγ�
	 * @param args
	 */
	public void testAdd() {
		selectCourse.add(new Course("2","���ݽṹ"));
		selectCourse.add(0, new Course("1","C���Գ������"));
		Course courses1[] = new Course[] {new Course("3","���ݿ�"),new Course("4","�ִ����ѧ"),new Course("5","���������")}; 
		selectCourse.addAll(Arrays.asList(courses1));
		Course courses2[] = new Course[] {new Course("6","�˳�ѧ"),new Course("7","java����"),new Course("8","��Ϣϵͳ���������")};
		selectCourse.addAll(5, Arrays.asList(courses2));
	}
	/**
	 * ��ѯ�γ�
	 * @param args
	 */
	/*����һ*/
	public void testForeach() {
		for(Course cr : selectCourse) {
			System.out.println("�γ�" + cr.getId() + ":" + cr.getName());
		}
	}
	/*������*/
	public void testIterator() {
		@SuppressWarnings("rawtypes")
		Iterator it = selectCourse.iterator();
		while(it.hasNext()) {
			Course cr = (Course) it.next();
			System.out.println("�γ�" + cr.getId() + ":" + cr.getName());
		}
	}
	/*������*/
	public void testFor() {
		for(int i = 0;i < selectCourse.size();i++) {
			Course cr = selectCourse.get(i);
			System.out.println("�γ�" + cr.getId() + ":" + cr.getName());
		}
	}
	public void testForeachForSet(Student stu) {
		System.out.println("��ѡ��" + stu.courses.size() + "�ſΣ�");
		for(Course cr:stu.courses) {//ֻ��ͨ��foreach����iterator��������ΪSet���Ĵ洢�������
			System.out.println("�γ�" + cr.getId() + ":" + cr.getName());
		}
	}
	/**
	 * collection��contains����
	 * �ж�List��selectCourse���Ƿ����ĳ���γ�
	 * @param args
	 */
	public void testListContains() {
		System.out.println("----------���ұ�ѡ�γ����Ƿ��������Ϊĳ��ֵ�ÿγ�----------");
		System.out.println("������Ҫ���ҵĿγ�����:");
			String name = console.next();
			Course cr = new Course();
			cr.setName(name);
			/*contains()�������жϼ��������Ƿ���ĳ��Ԫ��*/
		if(selectCourse.contains(cr)){ 
			System.out.println("��ѡ�γ��к��иÿγ�!");
			/*indexOf()����Ԫ������λ�õ�ֵ*/
			System.out.println(cr.getName() +"��IDΪ" + selectCourse.indexOf(cr));
		}else {
			System.out.println("��ѡ�γ���û�иÿγ�!");
		}
	}
	
	public static void main(String[] args) {
		SetTest st = new SetTest();
		st.testAdd();
		Student stu = new Student("1","С��");
		System.out.println("��ӭѧ��" + stu.getName() + "ѡ��!");
		System.out.println("��ѡ�γ���:");
		st.testForeach();
		for(int i = 0; i < 4;i++) {//��ѡ���ſγ�
			System.out.println("������γ̵�ID����ѡ��:");
			String courseId = console.next();
			for(Course cr:st.selectCourse) {
			if(cr.getId().equals(courseId)) {
				stu.courses.add(cr);
				}
			}
		}
		st.testForeachForSet(stu);
		st.testListContains();
		/**
		 * �ж�ѧ����ѡ�Ŀ�(courses����HashSet�����е�Ԫ��)���Ƿ����ĳ���γ�
		 * @param args
		 */
		System.out.println("--------�ж���ѡ�γ����Ƿ����ĳ�ſγ�--------");
		System.out.println("������Ҫ���ҵĿγ�����:");
		String name = console.next();
		Course cr = new Course();
		cr.setName(name);
		if(stu.courses.contains(cr)) {
			System.out.println("����ѡ���ſγ�!");
			}else {
			System.out.println("��û��ѡ���ſγ�!");
		}
		console.close();
	}
}


