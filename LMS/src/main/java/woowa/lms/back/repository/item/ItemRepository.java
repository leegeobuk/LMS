package woowa.lms.back.repository.item;

import woowa.lms.back.domain.item.Item;

import java.util.List;

public interface ItemRepository {
    void save(Item item);
    Item findById(Long id);
    List<Item> findByTitle(String title);
    List<Item> findAll();
}
