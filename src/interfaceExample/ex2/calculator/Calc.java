package interfaceExample.ex2.calculator;

public interface Calc {

	double PI = 3.14;
	int ERORR = -999999;
	
	int add(int a, int b);
	int substract(int a, int b);
	int times(int a, int b);
	int divide(int a, int b);
	
	default void description() {
		System.out.println("점수 계산기를 구현합니다");
		myMethod();
	}
	
	static int totla(int[] arr) {
		int total = 0;
		
		for(int i: arr) {
			total += i;
		}
		return total;
	}
	
	private void myMethod() {
		System.out.println("private method");
	}
	
	private static void myStaticMethod() {
		System.out.println("private static method");
	}
}
