package com.example;

import java.util.Map;
import java.util.Objects;

public class Student {
	
	private String name;
	private String subject;
	private int marks;
	private Map<String,Integer> studentMap; 
	
	public Student() {
		
	}
	
	public Student(String name, String subject, int marks) {
		super();
		this.name = name;
		this.subject = subject;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(marks, name, subject);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return marks == other.marks && Objects.equals(name, other.name) && Objects.equals(subject, other.subject);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", subject=" + subject + ", marks=" + marks + "]";
	}

	public Map<String,Integer> getStudentMap() {
		return studentMap;
	}

	public void setStudentMap(Map<String,Integer> studentMap) {
		this.studentMap = studentMap;
	}
	
	

}
