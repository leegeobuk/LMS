package woowa.lms.back.domain.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import woowa.lms.back.exception.OutOfStockException;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    protected ItemType type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ItemStatus status;

    private int stock;

    public void setStock(int stock) {
        this.stock = stock;
        this.status = this.stock > 0 ? ItemStatus.IN : ItemStatus.OUT;
    }

    public void addItem() {
        stock += 1;
    }

    public void removeItem()  {
        if (stock < 0) {
            throw new OutOfStockException("Out of stock");
        }
        stock -= 1;
    }

}
