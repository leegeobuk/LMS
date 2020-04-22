package woowa.lms.back.service.item;

import woowa.lms.back.domain.item.Item;
import woowa.lms.back.search.SearchCriteria;

import java.util.List;
import java.util.Optional;

public interface ItemService<T extends Item> {
    void save(T item);
    void edit(Long id, String title, String author, int stock);
    void delete(Long id);
    Optional<T> find(Long id);
    List<T> findAll();
}
