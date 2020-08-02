package threadExample.ex2;

public class Customer {

	private int myMoney;
	private Account myAccount;
	
	public Customer(int money) {
		this.myMoney = money;
	}
	
	public int getMoney() {
		return this.myMoney;
	}
	
	public void makeMyAccount(Bank bank) {
		this.myAccount = bank.makeAccount(0);
	}
	
	public boolean makeMyAccount(Bank bank, int money) {
		if(myMoney-money < 0) {
			return false;
		}
		this.myMoney -= money;
		this.myAccount = bank.makeAccount(money);
		return true;
	}
	
	public int getMyAccountBalance() {
		int Balance = myAccount.getBalance();
		return Balance;
	}
	
	public boolean depositMyAccount(int money) {
		if(myMoney-money < 0) {
			return false;
		}
		myAccount.deposit(money);
		this.myMoney -= money;
		return true;
	}
	
	public boolean withDrawMyAccount(int money) {
		if(myAccount.getBalance() - money < 0) {
			return false;
		}
		myAccount.withDraw(money);
		myMoney += money;
		return true;
	}
	
	public void shareAccount(Customer customer) {
		this.myAccount = customer.myAccount;
	}
	
}
