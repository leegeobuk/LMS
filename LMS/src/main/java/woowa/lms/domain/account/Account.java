package woowa.lms.domain.account;

import javax.persistence.*;

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

    protected Account() {
    }

    protected Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
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
