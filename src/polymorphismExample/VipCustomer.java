package polymorphismExample;

public class VipCustomer extends Customer {

	private int agentID;
	
	public VipCustomer(String customerName, int agentID) {
		super(customerName);
		customerGrade = "VIP";
		this.agentID = agentID;
		bonusRatio = 0.03;
	}

	@Override
	public void showInfo() {
		System.out.println("Customer ID: " + customerID +
				" Customer Grade: " + customerGrade +
				" Customer Name: " + customerName +
				" Customer Point: " + bonusPoint +
				" Agent ID: " + agentID);
	}
	
	
	
	
}
