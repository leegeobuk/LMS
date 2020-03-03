package woowa.lms.domain.rental;

import woowa.lms.domain.item.Item;

import javax.persistence.*;

@Entity
public class RentalItem {

    @Id @GeneratedValue
    @Column(name = "rental_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public static final int COUNT = 1;

    public Long getId() {
        return id;
    }

    public Rental getRental() {
        return rental;
    }

    public Item getItem() {
        return item;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public static RentalItem create(Item item) {
        RentalItem rentalItem = new RentalItem();
        rentalItem.setItem(item);
        item.removeItem(COUNT);
        return rentalItem;
    }

    public void returnRentalItem() {
        item.addItem(COUNT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentalItem rentalItem = (RentalItem) o;

        return getItem().equals(rentalItem.getItem());
    }

}
