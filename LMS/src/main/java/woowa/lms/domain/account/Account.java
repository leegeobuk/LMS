package woowa.lms.domain.account;

import woowa.lms.domain.AccountItem;
import woowa.lms.domain.AccountLibrary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
public abstract class Account {

    @Id
    @Column(name = "account_id", length = 15)
    private String id;

    @Column(nullable = false, length = 13)
    private String pw;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "auth", nullable = false)
    protected AccountType accountType;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 11)
    private String contact;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccountLibrary> accountLibraries = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private List<AccountItem> accountItems = new ArrayList<>();

    protected Account() {
    }

    protected Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public List<AccountLibrary> getAccountLibraries() {
        return accountLibraries;
    }

    public List<AccountItem> getAccountItems() {
        return accountItems;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
