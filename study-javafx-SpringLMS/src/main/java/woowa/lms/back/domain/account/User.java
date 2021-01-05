package woowa.lms.back.domain.account;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("user")
@OnDelete(action = OnDeleteAction.CASCADE)
@NoArgsConstructor
public class User extends Account {

	private User(String id, String pw) {
		super(id, pw);
		accountType = AccountType.USER;
	}

	public static User of(String id, String pw) {
		return new User(id, pw);
	}

	public static User of(String id, String pw, String name, String contact) {
		User user = new User(id, pw);
		user.setName(name);
		user.setContact(contact);
		return user;
	}
}