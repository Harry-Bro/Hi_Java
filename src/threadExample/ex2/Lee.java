package threadExample.ex2;

public class Lee extends Customer implements Runnable {

	public Lee(int money) {
		super(money);
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			if(depositMyAccount(100)) {
				System.out.println((i+1) +" Lee 입금성공 ");
			}
			System.out.println("[Lee]현재 나의 통장 잔고: " + getMyAccountBalance());
		}
	}

}
