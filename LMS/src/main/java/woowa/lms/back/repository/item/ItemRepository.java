package woowa.lms.back.repository.item;

import woowa.lms.back.domain.item.Item;

import java.util.List;

public interface ItemRepository<T extends Item> {
    void save(T item);
    Item findById(Long id);
    List<Item> findByTitle(String title);
    List<Item> findAll();
}
