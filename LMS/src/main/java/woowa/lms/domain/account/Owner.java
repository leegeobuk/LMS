package woowa.lms.domain.account;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("owner")
public class Owner extends Account {

    protected Owner() {
    }

    private Owner(String id) {
        super(id);
        accountType = AccountType.OWNER;
    }

    public static Owner of(String id) {
        return new Owner(id);
    }
}
