package singltonPatternExample;

public class CardCompanyTest {

	public static void main(String[] args) {
		
		Company company = Company.getInstance();
		
		Card myCard = company.createCard();
		Card yourCard = company.createCard();
		
		System.out.println(myCard.getCardNum());
		System.out.println(yourCard.getCardNum());

	}

}
