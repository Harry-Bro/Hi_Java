package arrayListExample;

public class StudentSubjectTest {

	public static void main(String[] args) {

		Student stu1 = new Student("kim");
		Student stu2 = new Student("Lee");
		
		stu1.addSubject("korean", 100);
		stu1.addSubject("english", 90);
		
		stu1.getInfo();
		
		stu2.addSubject("science", 100);
		stu2.addSubject("math", 90);
		
		stu2.getInfo();


	}

}
