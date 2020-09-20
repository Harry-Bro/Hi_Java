package string_example;

public class Practice1 {

	public static void main(String[] args) {
		String str = "abcde";
		
		String newStr = str.replace("a", "A");
		System.out.println(newStr);
		
		String str2 = "a b c d e";
		String[] splitStr = str2.split(" ");
		for(String s : splitStr) {
			System.out.println(s);
		}
		
//		byte[] byteArr = str.getBytes();
//		for(byte a : byteArr) {
//			System.out.println(a);
//			
//		}
//		System.out.println(str.contains("ab"));
//		System.out.println(str.compareTo(str2));
//		System.out.println(str.substring(3));
//		System.out.println(str.toUpperCase());
//		System.out.println(str.charAt(3));
//		System.out.println(str.indexOf("c"));
//		System.out.println(str);
		
//		StringBuffer str2 = new StringBuffer();
//		str2.append("abc");
//		str2.append("def");
//		System.out.println(str2.indexOf("c"));
//		System.out.println(str2);
//		
		
//		String str2 = "a b c d e";
//		String[] strArr = str2.split(" ");
//		for(String strr: strArr) {
//			System.out.println(strr);
//			
//		}
//		
//		Integer num = 0;
//		String toStringNum = num.toString(); 
//		String valueOfNum = String.valueOf(num);
//		System.out.println(toStringNum);
//		System.out.println(valueOfNum);
	}
	
	
}
