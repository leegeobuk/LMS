package woowa.lms.back.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.repository.item.ItemRepository;
import woowa.lms.back.search.BookSearchCriteria;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService implements ItemService<Book> {

    private final ItemRepository itemRepository;

    @Transactional
    public void save(Book book) {
        itemRepository.save(book);
    }

    @Transactional
    public void edit(Long id, String title, String author, int stock) {
        find(id)
            .ifPresent(book -> {
                book.setTitle(title);
                book.setAuthor(author);
                book.setStock(stock);
            });
    }

    @Transactional
    @Override
    public void delete(Long id) {
        find(id)
            .ifPresent(itemRepository::delete);
    }

    public Optional<Book> find(Long id) {
        return itemRepository.findBookById(id);
    }

    public List<Book> search(BookSearchCriteria criteria) {
        return itemRepository.search(criteria)
            .stream().map(Book.class::cast).collect(toUnmodifiableList());
    }

    public List<Book> findAll() {
        return itemRepository.findAll()
            .stream().map(Book.class::cast).collect(toUnmodifiableList());
    }
}
