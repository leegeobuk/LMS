package woowa.lms.back.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import woowa.lms.back.domain.item.Book;

@AllArgsConstructor
@Getter
public class BookSearchCriteria implements SearchCriteria<Book> {
    private String title;
    private String author;
}
