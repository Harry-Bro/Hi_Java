package polymorphismExample;

public class GoldCustomer extends Customer {

	public GoldCustomer(String customerNmae) {
		super(customerNmae);
		customerGrade = "Gold";
		bonusRatio = 0.02;
	}
	
}
