package woowa.lms.back.repository.item;

import woowa.lms.back.domain.item.Item;
import woowa.lms.back.search.BookSearchCriteria;

import java.util.List;

public interface CustomItemRepository {
    List<Item> search(BookSearchCriteria criteria);
}
