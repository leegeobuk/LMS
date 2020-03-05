package woowa.lms.domain.item;

import woowa.lms.exception.OutOfStockException;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    protected ItemType type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ItemStatus status;

    private int stock;

    protected Item() {
    }

    public Long getId() {
        return id;
    }

    public ItemType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public int getStock() {
        return stock;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

}
