package woowa.lms.back.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.repository.item.BookRepository;

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

//    @Transactional
//    public void edit() {
        // TODO: 2020-03-04 Implement it when Form is implemented
//    }

    public Book find(Long id) {
        return (Book) bookRepository.findById(id);
    }

    @Override
    public List<Book> find(String title) {
        return bookRepository.findByTitle(title).stream()
            .map(Book.class::cast).collect(toUnmodifiableList());
    }

    public List<Book> findAll() {
        return bookRepository.findAll().stream()
            .map(Book.class::cast).collect(toUnmodifiableList());
    }
}
