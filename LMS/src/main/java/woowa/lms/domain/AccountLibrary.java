package woowa.lms.domain;

import woowa.lms.domain.account.Account;

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

    public static AccountLibrary of(Account account, Library library) {
        AccountLibrary accountLibrary = new AccountLibrary();
        accountLibrary.setAccount(account);
        accountLibrary.setLibrary(library);
        return accountLibrary;
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
        account.getAccountLibraries().add(this);
    }

    public void setLibrary(Library library) {
        this.library = library;
        library.getAccountLibraries().add(this);
    }
}
