package woowa.lms.domain.item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String author;

    @Enumerated(value = EnumType.STRING)
    private ItemStatus status;
    private int stock;

    protected Item() {
    }

    public Item(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
}
