package woowa.lms.back.repository.item;

import woowa.lms.back.domain.item.Item;
import woowa.lms.back.search.SearchCriteria;

import java.util.List;

public interface ItemRepository<T extends Item> {
    void save(T item);
    void delete(T book);
    Item findById(Long id);
    List<Item> findAll();
}
