package woowa.lms.back.domain.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import woowa.lms.back.domain.rental.Rental;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor
@Getter
public abstract class Account implements Persistable<String> {

    @Id
    @Column(name = "account_id", length = 15)
    private String id;

    @Column(nullable = false, length = 15)
    @Setter
    private String pw;

    @CreatedDate
    private LocalDate createdDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "auth", nullable = false)
    protected AccountType accountType;

    @Column(nullable = false, length = 30)
    @Setter
    private String name;

    @Column(nullable = false, length = 11)
    @Setter
    private String contact;

    @OneToMany(mappedBy = "account")
    private List<Rental> rentals = new ArrayList<>();

    protected Account(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return createdDate == null;
    }
}
