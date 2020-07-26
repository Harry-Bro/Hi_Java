package polymorphismExample;

public class Customer {
	
	private static int customerNum = 10001;
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	double salesRatio = 0.01;
	int bonusPoint; // 포인트
	double bonusRatio; // 적립률
	
	public Customer() {
		init();
	}
	
	public Customer(String customerName) {
		init();
		this.customerName = customerName;
	}
	
	private void init() {
		this.customerGrade = "Siver";
		bonusRatio = 0.01;
		customerID = customerNum;
		customerNum++;
	}
	
	public int calcPrice(int price) {
		nowPoint(price);
		return price - (int)(price * salesRatio);
	}
	
	public int nowPoint(int price) {
		bonusPoint = (int) (price * bonusRatio);
		return bonusPoint;
	}
	
	public void showInfo() {
		System.out.println("Customer ID: " + customerID +
				" Customer Grade: " + customerGrade +
				" Customer Name: " + customerName +
				" Customer Point: " + bonusPoint);
	}

}
