package woowa.lms.back.domain.account;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("admin")
@OnDelete(action = OnDeleteAction.CASCADE)
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
