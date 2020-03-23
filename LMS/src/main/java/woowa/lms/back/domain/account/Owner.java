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

    private Owner(String id) {
        super(id);
        accountType = AccountType.OWNER;
    }

    public static Owner of(String id, String pw) {
        Owner owner = new Owner(id);
        owner.setPw(pw);
        return owner;
    }
}
