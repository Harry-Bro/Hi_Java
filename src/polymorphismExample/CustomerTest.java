package polymorphismExample;

import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		Customer customerLee = new Customer("이");
		Customer customerPark = new Customer("박");
		Customer customerKim = new GoldCustomer("김");
		Customer customerNam = new GoldCustomer("남");
		Customer customerY = new VipCustomer("윤", 90001);
		
		customerList.add(customerLee);
		customerList.add(customerPark);
		customerList.add(customerKim);
		customerList.add(customerNam);
		customerList.add(customerY);
		
		for(Customer customer:customerList) {
			customer.calcPrice(1000);
		}
		
		for(Customer customer:customerList) {
			customer.showInfo();
		}
		
	}

}
