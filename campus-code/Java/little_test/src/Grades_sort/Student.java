package Grades_sort;

public class Student implements Comparable<Student>{
	private String name;
	private int grades;
	public Student(String name, int grades) {
		this.name = name;
		this.grades = grades;
	}
	public int get_grades() {
		return this.grades;
	}
	public String get_name() {
		return this.name;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.get_grades()>o.get_grades()? 1: -1;
	}

}
