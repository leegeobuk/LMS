package woowa.lms.domain.rental;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import woowa.lms.domain.item.Item;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class RentalItem {

    @Id @GeneratedValue
    @Column(name = "rental_item_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private RentalItem(Item item) {
        this.item = item;
    }

    public static RentalItem create(Item item) {
        RentalItem rentalItem = new RentalItem(item);
        item.removeItem();
        return rentalItem;
    }

    public void returnRentalItem() {
        item.addItem();
    }

}
