package com.imooc;

import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student>{
	private String id;
	private String name;
	Set<Course> courses = new HashSet<Course>();
	public Student(String id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public Student() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);
	}

}
