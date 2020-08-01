package threadExample.ex2;

public class Bank {
	
	private String bankName;
	
	public Bank(String bankName) {
		this.bankName = bankName;
	}
	
	public Account makeAccount(int money) {
		Account account = Account.getAccount(money);
		return account;
	}
	
}
