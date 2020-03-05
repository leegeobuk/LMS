package woowa.lms.domain.account;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("customer")
@NoArgsConstructor
public class Customer extends Account {

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