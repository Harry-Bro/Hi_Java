package threadExample.ex2;

public class Account {

	private static Account instance;
	private int balance;
	
	public static Account getAccount(int balance) {
		if(instance == null) {
			instance = new Account();
			instance.balance = balance;
		}
		
		return instance;
	}
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public boolean withDraw(int money) {
		if(balance - money < 0) {
			return false;
		}
		this.balance -= money;
		return true;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
}
