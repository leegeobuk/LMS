package woowa.lms.back.domain.account;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
@OnDelete(action = OnDeleteAction.CASCADE)
@NoArgsConstructor
public class Admin extends Account {

	private Admin(String id, String pw) {
		super(id, pw);
		accountType = AccountType.ADMIN;
	}

	public static Admin of(String id, String pw) {
		return new Admin(id, pw);
	}

	public static Admin of(String id, String pw, String name, String contact) {
		Admin admin = new Admin(id, pw);
		admin.setName(name);
		admin.setContact(contact);
		return admin;
	}
}
