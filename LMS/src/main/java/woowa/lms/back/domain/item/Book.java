package woowa.lms.back.domain.item;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Book extends Item {

	protected Book() {
		type = ItemType.BOOK;
	}

	public static Book of(String title, String author, int stock) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
//		book.setStatus(ItemStatus.IN);
		book.setStock(stock);
		return book;
	}


}
