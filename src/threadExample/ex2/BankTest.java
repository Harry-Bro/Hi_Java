package threadExample.ex2;

public class BankTest {

	public static void main(String[] args) throws InterruptedException {
		
		Bank kbBank = new Bank("KB");
		Customer lee = new Lee(10000);
		Customer leeWife = new LeeWife(0);
		
		lee.makeMyAccount(kbBank);
		
		leeWife.shareAccount(lee);

		Thread leeThread = new Thread((Runnable)lee);
		Thread leeWifeThread = new Thread((Runnable)leeWife);
		
		leeThread.start();
		leeThread.join();
		leeWifeThread.start();
		leeWifeThread.join();
		
		
	}
	
}
