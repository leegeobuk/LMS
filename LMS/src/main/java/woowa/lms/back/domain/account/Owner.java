package woowa.lms.back.domain.account;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("owner")
@OnDelete(action = OnDeleteAction.CASCADE)
@NoArgsConstructor
public class Owner extends Account {

    private Owner(String id, String pw) {
        super(id, pw);
        accountType = AccountType.OWNER;
    }

    public static Owner of(String id, String pw) {
        return new Owner(id, pw);
    }

    public static Owner of(String id, String pw, String name, String contact) {
        Owner owner = new Owner(id, pw);
        owner.setName(name);
        owner.setContact(contact);
        return owner;
    }
}
