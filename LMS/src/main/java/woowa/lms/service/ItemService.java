package woowa.lms.service;

import woowa.lms.domain.item.Item;
import woowa.lms.repository.ItemRepository;

import java.util.List;

public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public void edit() {
        // TODO: 2020-03-04 Implement it when Form is implemented
    }

    public Item find(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
