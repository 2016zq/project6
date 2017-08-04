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
	 * 增加课程
	 * @param args
	 */
	public void testAdd() {
		selectCourse.add(new Course("2","数据结构"));
		selectCourse.add(0, new Course("1","C语言程序设计"));
		Course courses1[] = new Course[] {new Course("3","数据库"),new Course("4","现代会计学"),new Course("5","计算机网络")}; 
		selectCourse.addAll(Arrays.asList(courses1));
		Course courses2[] = new Course[] {new Course("6","运筹学"),new Course("7","java语言"),new Course("8","信息系统分析与设计")};
		selectCourse.addAll(5, Arrays.asList(courses2));
	}
	/**
	 * 查询课程
	 * @param args
	 */
	/*方法一*/
	public void testForeach() {
		for(Course cr : selectCourse) {
			System.out.println("课程" + cr.getId() + ":" + cr.getName());
		}
	}
	/*方法二*/
	public void testIterator() {
		@SuppressWarnings("rawtypes")
		Iterator it = selectCourse.iterator();
		while(it.hasNext()) {
			Course cr = (Course) it.next();
			System.out.println("课程" + cr.getId() + ":" + cr.getName());
		}
	}
	/*方法三*/
	public void testFor() {
		for(int i = 0;i < selectCourse.size();i++) {
			Course cr = selectCourse.get(i);
			System.out.println("课程" + cr.getId() + ":" + cr.getName());
		}
	}
	public void testForeachForSet(Student stu) {
		System.out.println("共选了" + stu.courses.size() + "门课：");
		for(Course cr:stu.courses) {//只能通过foreach或者iterator遍历，因为Set集的存储是无序的
			System.out.println("课程" + cr.getId() + ":" + cr.getName());
		}
	}
	/**
	 * collection的contains方法
	 * 判断List的selectCourse中是否包含某个课程
	 * @param args
	 */
	public void testListContains() {
		System.out.println("----------查找备选课程中是否包含名称为某个值得课程----------");
		System.out.println("请输入要查找的课程名称:");
			String name = console.next();
			Course cr = new Course();
			cr.setName(name);
			/*contains()方法，判断集合里面是否含有某个元素*/
		if(selectCourse.contains(cr)){ 
			System.out.println("备选课程中含有该课程!");
			/*indexOf()返回元素索引位置的值*/
			System.out.println(cr.getName() +"的ID为" + selectCourse.indexOf(cr));
		}else {
			System.out.println("备选课程中没有该课程!");
		}
	}
	
	public static void main(String[] args) {
		SetTest st = new SetTest();
		st.testAdd();
		Student stu = new Student("1","小明");
		System.out.println("欢迎学生" + stu.getName() + "选课!");
		System.out.println("可选课程有:");
		st.testForeach();
		for(int i = 0; i < 4;i++) {//可选四门课程
			System.out.println("请输入课程的ID进行选课:");
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
		 * 判断学生所选的课(courses属于HashSet集合中的元素)中是否包含某个课程
		 * @param args
		 */
		System.out.println("--------判断所选课程中是否包含某门课程--------");
		System.out.println("请输入要查找的课程名称:");
		String name = console.next();
		Course cr = new Course();
		cr.setName(name);
		if(stu.courses.contains(cr)) {
			System.out.println("您已选这门课程!");
			}else {
			System.out.println("您没有选这门课程!");
		}
		console.close();
	}
}


