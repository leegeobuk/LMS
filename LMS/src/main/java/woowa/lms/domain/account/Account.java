package woowa.lms.domain.account;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class Account {

    @Id
    @Column(name = "account_id")
    private String id;

    private String pw;
    private String name;
    private String contact;

    public Account() {
    }

    public Account(String id, String pw, String name, String contact) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.contact = contact;
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
