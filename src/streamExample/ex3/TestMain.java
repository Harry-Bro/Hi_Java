package streamExample.ex3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestMain {

	public static void main(String[] args) {
		
		List<Member> list = Arrays.asList(
				new Member("고길동", Member.MALE, 50),
				new Member("고길동", Member.FEMALE, 30),
				new Member("고길동", Member.MALE, 20));
		
		Stream<Member> stream = list.stream();
		Double avg = stream.filter(s->s.getSex()==Member.MALE)
				.mapToInt(s->s.getAge())
				.average()
				.getAsDouble();
		System.out.println(avg);
	}
	
}
