package singltonPatternExample;

public class Card {
	
	private static int serialNum = 10001;
	private int cardNum = 0;
	

	public Card() {
		cardNum = serialNum;
		serialNum++;
	}
	
	public int getCardNum() {
		return cardNum;		
	}
	

}
