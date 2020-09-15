package test;

public class Main {
	public static void main(String[] args) {
		
		System.out.println(Student.stuNum); // 1000
		Student.stuNum++;
		System.out.println(Student.stuNum); // 1001
		
		Student stu1 = new Student();
		Student stu2 = new Student();
		
		Student.stuNum++;
		System.out.println(stu1.stuNum);
		System.out.println(stu2.stuNum);
		System.out.println(Student.stuNum);
		
		stu1.stuNum = 2000;
		System.out.println(stu1.stuNum); // 2000
		System.out.println(stu2.stuNum); // 2000
		
	}
	
}
