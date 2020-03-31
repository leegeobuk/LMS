package woowa.lms.back.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.repository.item.ItemRepository;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService implements ItemService<Book> {

    private final ItemRepository<Book> itemRepository;

    @Transactional
    public void save(Book book) {
        itemRepository.save(book);
    }

//    @Transactional
//    public void edit() {
        // TODO: 2020-03-04 Implement it when Form is implemented
//    }

    public Book find(Long id) {
        return (Book) itemRepository.findById(id);
    }

    @Override
    public List<Book> find(String title) {
        return itemRepository.findByTitle(title).stream()
            .map(Book.class::cast).collect(toUnmodifiableList());
    }

    public List<Book> findAll() {
        return itemRepository.findAll().stream()
            .map(Book.class::cast).collect(toUnmodifiableList());
    }
}
