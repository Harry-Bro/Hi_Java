package interfaceExample.ex1.callcentor;

public class PriorityAllocation implements Schedular {

	@Override
	public void getNextCall() {
		System.out.println("고객등급이 높은 고객의 call을 먼저 가져옵니다");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("업무 숙련도가 높은 상담원에게 먼저 배분합니다.");
	}

	
	
}
