package woowa.lms.domain;

import woowa.lms.domain.account.Account;
import woowa.lms.domain.account.Owner;

import javax.persistence.*;

@Entity
public class AccountLibrary {

    @Id
    @GeneratedValue
    @Column(name = "account_lib_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lib_id")
    private Library library;

    protected AccountLibrary() {
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Library getLibrary() {
        return library;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
