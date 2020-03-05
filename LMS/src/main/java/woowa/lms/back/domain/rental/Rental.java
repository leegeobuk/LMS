package woowa.lms.back.domain.rental;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import woowa.lms.back.domain.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Rental {

    @Id @GeneratedValue
    @Column(name = "rental_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private List<RentalItem> rentalItems = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private RentalStatus rentalStatus;

    @Column(nullable = false)
    private LocalDateTime rentalDate;

    @Column(nullable = false)
    private LocalDateTime returnDate;

    public void setAccount(Account account) {
        this.account = account;
        this.account.getRentals().add(this);
    }

    public void setRentalItem(RentalItem rentalItem) {
        getRentalItems().add(rentalItem);
        rentalItem.setRental(this);
    }

    public static Rental create(Account account, RentalItem... rentalItems) {
        Rental rental = new Rental();
        rental.setAccount(account);
        for (RentalItem rentalItem : rentalItems) {
            rental.setRentalItem(rentalItem);
        }
        rental.setRentalDate(LocalDateTime.now());
        rental.setReturnDate(rental.getRentalDate().plusWeeks(2L));
        rental.setRentalStatus(RentalStatus.LENDED);
        return rental;
    }

    public void endRental() {
        setRentalStatus(RentalStatus.RETURNED);
        for (RentalItem rentalItem : rentalItems) {
            rentalItem.returnRentalItem();
        }
    }
}
