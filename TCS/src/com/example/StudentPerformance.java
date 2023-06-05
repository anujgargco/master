package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentPerformance {
	
	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		Student student = new Student();
		student.setName("Ravi");
		
		Map<String,Integer> studentMaps = new HashMap<>();
		studentMaps.put("MATHS", 50);
		studentMaps.put("ENGLISH", 60);
		student.setStudentMap(studentMaps);
		students.add(student);
		
		student = new Student();
		student.setName("Raju");
		
		studentMaps = new HashMap<>();
		studentMaps.put("MATHS", 70);
		studentMaps.put("ENGLISH", 80);
		student.setStudentMap(studentMaps);
		students.add(student);	
		
		students.stream().filter(p-> p.getStudentMap().containsKey("MATHS")).sorted().forEach(p->System.out.println(p) );
		students.stream().filter(p-> p.getStudentMap().containsKey("ENGLISH")).sorted().forEach(p-> System.out.println(p));
		
		
		
			}

}
