package woowa.lms.domain.account;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("owner")
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
