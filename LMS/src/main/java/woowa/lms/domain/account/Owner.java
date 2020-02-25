package woowa.lms.domain.account;

import woowa.lms.domain.OwnerLibrary;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("owner")
public class Owner extends Account {

    @OneToMany(mappedBy = "owner")
    private List<OwnerLibrary> ownerLibraries = new ArrayList<>();

    protected Owner() {
    }

    private Owner(String id) {
        super(id);
        accountType = AccountType.OWNER;
    }

    public static Owner of(String id) {
        return new Owner(id);
    }

    public List<OwnerLibrary> getOwnerLibraries() {
        return ownerLibraries;
    }
}
