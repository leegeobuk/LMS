package woowa.lms.domain;

import woowa.lms.domain.account.Owner;

import javax.persistence.*;

@Entity
public class OwnerLibrary {

    @Id
    @GeneratedValue
    @Column(name = "owner_lib_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lib_id")
    private Library library;

    protected OwnerLibrary() {
    }

    public Long getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public Library getLibrary() {
        return library;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
