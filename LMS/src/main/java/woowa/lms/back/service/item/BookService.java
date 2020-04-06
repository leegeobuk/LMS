package woowa.lms.back.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.repository.item.BookRepository;
import woowa.lms.back.search.BookSearchCriteria;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService implements ItemService<Book> {

    private final BookRepository bookRepository;

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void edit(Long id, String title, String author, int stock) {
        Book book = find(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setStock(stock);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Book book = find(id);
        bookRepository.delete(book);
    }

    public Book find(Long id) {
        return (Book) bookRepository.findById(id);
    }

    public List<Book> search(BookSearchCriteria criteria) {
        return bookRepository.search(criteria)
            .stream().map(Book.class::cast).collect(toUnmodifiableList());
    }

    public List<Book> findAll() {
        return bookRepository.findAll()
            .stream().map(Book.class::cast).collect(toUnmodifiableList());
    }
}
