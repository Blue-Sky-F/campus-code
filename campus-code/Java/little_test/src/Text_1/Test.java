package Text_1;

public class Test {
	public static void main(String args[]) {
		Student s1 = new Student(2);
		Student s2 = s1;
		s1.set(3);
		System.out.println(s2.grades);
	}
}
class Student{
	int grades;
	Student(int g){
		grades = g;
	}
	void set(int g){
		grades = g;
	}
}
