package woowa.lms.back.service.item;

import woowa.lms.back.domain.item.Item;

import java.util.List;

public interface ItemService<T extends Item> {
    void save(T item);
//    void edit();
    T find(Long id);
    List<T> find(String title);
    List<T> findAll();
}
