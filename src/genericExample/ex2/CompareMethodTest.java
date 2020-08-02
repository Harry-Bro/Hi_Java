package genericExample.ex2;

public class CompareMethodTest {

	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<>(2, "홍길동");
		
		boolean result = Util.Comapre(p1, p2);
		System.out.println(result);
		
	}
	
}
