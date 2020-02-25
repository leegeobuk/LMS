package woowa.lms.domain.item;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends Item {

	public Book() {
	}

	public Book(Long id) {
		super(id);
	}
}
