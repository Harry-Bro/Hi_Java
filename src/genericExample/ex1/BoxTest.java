package genericExample.ex1;

public class BoxTest {

	public static void main(String[] args) {
		
		Box<Apple> appleBox = new Box<>();
		Apple apple = new Apple(10, 1000);
		
		appleBox.setBox(apple);
		
		Apple unBoxingApple = appleBox.getBox();
		int cost = unBoxingApple.getCost();
		int count = unBoxingApple.getCount();
		
		System.out.println(cost);
		System.out.println(count);
		
	}
	
}
