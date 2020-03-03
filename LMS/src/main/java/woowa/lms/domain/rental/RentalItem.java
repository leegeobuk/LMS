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

    private int count;

    public Long getId() {
        return id;
    }

    public Rental getRental() {
        return rental;
    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static RentalItem createRentalItem(Item item, int count) {
        RentalItem rentalItem = new RentalItem();
        rentalItem.setItem(item);
        rentalItem.setCount(count);
        item.removeItem(count);
        return rentalItem;
    }

    public void returnRentalItem() {
        item.addItem(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentalItem rentalItem = (RentalItem) o;

        if (getCount() != rentalItem.getCount()) return false;
        return getItem().equals(rentalItem.getItem());
    }

}
