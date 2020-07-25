package arrayListExample;

import java.util.ArrayList;

public class Student {
	
	String name;
	ArrayList<Subject> subjectList;
	
	public Student(String name) {
		this.name = name;
		subjectList = new ArrayList<Subject>();
	}
	
	public void addSubject(String name, int score) {
		Subject subject = new Subject(name, score);
		subjectList.add(subject);
	}

	public void getInfo() {
		int total = 0;
		for(int i=0; i<subjectList.size(); i++) {
			total += subjectList.get(i).getScore();
			System.out.println("학생의 이름: " + this.name + 
					"과목: " + subjectList.get(i).getName() +
					"점수: " + subjectList.get(i).getScore());
		}
		System.out.println("총 점수는 " + total + "입니다.");
	}
	
}
