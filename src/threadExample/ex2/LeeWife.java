package threadExample.ex2;

public class LeeWife extends Customer implements Runnable {

	public LeeWife(int money) {
		super(money);
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			
			if(withDrawMyAccount(100)) {
				System.out.println((i+1) + "와이프 출금성공");
				System.out.println("[wife]현재 나의 통장 잔고: " + getMyAccountBalance());
			}
			
		}
	}

	
	
}
