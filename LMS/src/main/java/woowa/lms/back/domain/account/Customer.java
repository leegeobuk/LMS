package woowa.lms.back.domain.account;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("customer")
@OnDelete(action = OnDeleteAction.CASCADE)
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