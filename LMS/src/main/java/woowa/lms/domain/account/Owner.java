package woowa.lms.domain.account;

import woowa.lms.domain.OwnerLibrary;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("owner")
public class Owner extends Account {

//    @OneToMany()
//    private OwnerLibrary ownerLibrary;

    public Owner() {
    }

    public Owner(String id, String pw, String name, String contact) {
        super(id, pw, name, contact);
    }
}
