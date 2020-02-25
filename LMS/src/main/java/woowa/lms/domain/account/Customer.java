package woowa.lms.domain.account;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("customer")
public class Customer extends Account {

	public Customer() {
	}

	public Customer(String id, String pw, String name, String contact) {
		super(id, pw, name, contact);
	}
}