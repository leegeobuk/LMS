package woowa.lms.domain.account;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Account {

	public Admin() {
	}

	public Admin(String id, String pw, String name, String contact) {
		super(id, pw, name, contact);
	}
}
