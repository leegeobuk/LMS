package woowa.lms.domain.account;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("admin")
@NoArgsConstructor
public class Admin extends Account {

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
