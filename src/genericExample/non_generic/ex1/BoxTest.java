package genericExample.non_generic.ex1;

public class BoxTest {

	public static void main(String[] args) {
		
		Box box = new Box();
		
		String str = "ABC";
		
		box.setBox(str); // Object타입으로 형변환되서 저
		
		String getStr = (String)box.getBox();
		System.out.println(getStr);
//		System.out.println(box.getBox()); // 자동 형변
		
	}
	
}
