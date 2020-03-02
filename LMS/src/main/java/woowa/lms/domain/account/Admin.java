package woowa.lms.domain.account;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Account {

	protected Admin() {
	}

	private Admin(String id) {
		super(id);
		accountType = AccountType.ADMIN;
	}

	public static Admin of(String id, String pw) {
		Admin admin = new Admin(id);
		admin.setPw(pw);
		return admin;
	}
}
