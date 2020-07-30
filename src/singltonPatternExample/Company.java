package singltonPatternExample;

public class Company {
	
	private static Company instance;

	private Company() {}
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
	
	public Card createCard() {
		Card card = new Card();
		return card;
	}
	
	
	
}
