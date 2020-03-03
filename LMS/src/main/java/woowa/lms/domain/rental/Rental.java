package woowa.lms.domain.rental;

import woowa.lms.domain.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rental {

    @Id @GeneratedValue
    @Column(name = "rental_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<RentalItem> rentalItems = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private RentalStatus rentalStatus;

    @Column(nullable = false)
    private LocalDateTime rentalDate;

    @Column(nullable = false)
    private LocalDateTime returnDate;

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public List<RentalItem> getRentalItems() {
        return rentalItems;
    }

    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setAccount(Account account) {
        this.account = account;
        this.account.getRentals().add(this);
    }

    public void setRentalItem(RentalItem rentalItem) {
        getRentalItems().add(rentalItem);
        rentalItem.setRental(this);
    }

    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
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
