package woowa.lms.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends Item {

	public Book() {
		type = ItemType.BOOK;
	}
}
