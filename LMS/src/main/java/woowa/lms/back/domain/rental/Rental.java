package woowa.lms.back.domain.rental;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationEventPublisher;
import woowa.lms.back.domain.account.Account;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private List<RentalItem> rentalItems = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private RentalStatus rentalStatus;

    @Column(nullable = false)
    private LocalDate lendDate;

    @Column(nullable = false)
    private LocalDate returnDate;

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
        rental.setLendDate(LocalDate.now());
        rental.setReturnDate(rental.getLendDate().plusDays(14));
        rental.setRentalStatus(RentalStatus.DUE);
        return rental;
    }

    public void endRental(Long itemId) {
        int index = findRentalItemIndex(itemId);
        RentalItem returningItem = rentalItems.get(index);
        returningItem.returnRentalItem();
        rentalItems.remove(returningItem);
    }

    private int findRentalItemIndex(Long itemId) {
        for (int i = 0; i < rentalItems.size(); i++) {
            if (rentalItems.get(i).getItem().getId().equals(itemId)) {
                return i;
            }
        }
        return -1;
    }
}
