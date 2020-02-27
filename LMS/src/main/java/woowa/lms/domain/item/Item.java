package woowa.lms.domain.item;

import woowa.lms.domain.AccountItem;
import woowa.lms.domain.Library;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lib_id")
//    @Column(nullable = false)
    private Library library;

    @OneToMany(mappedBy = "item")
    private List<AccountItem> accountItems = new ArrayList<>();

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

    public Library getLibrary() {
        return library;
    }

    public List<AccountItem> getAccountItems() {
        return accountItems;
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

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

}
