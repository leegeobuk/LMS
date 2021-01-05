package woowa.lms.front.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.item.ItemStatus;

public class BookModel {

    private SimpleLongProperty id;
    private SimpleStringProperty title;
    private SimpleStringProperty author;
    private ItemStatus status;
    private SimpleIntegerProperty stock;

    public BookModel(Book book) {
        this.id = new SimpleLongProperty(book.getId());
        this.title = new SimpleStringProperty(book.getTitle());
        this.author = new SimpleStringProperty(book.getAuthor());
        this.status = book.getStatus();
        this.stock = new SimpleIntegerProperty(book.getStock());
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public SimpleIntegerProperty stockProperty() {
        return stock;
    }

    public Long getId() {
        return id.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getAuthor() {
        return author.get();
    }

    public ItemStatus getStatus() {
        return status;
    }

    public int getStock() {
        return stock.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }
}
