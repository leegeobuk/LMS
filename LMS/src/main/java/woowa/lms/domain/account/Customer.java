package woowa.lms.domain.account;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("customer")
public class Customer extends Account {

	protected Customer() {
	}

	private Customer(String id) {
		super(id);
		accountType = AccountType.CUSTOMER;
	}

	public static Customer of(String id, String pw) {
		Customer customer = new Customer(id);
		customer.setPw(pw);
		return customer;
	}
}