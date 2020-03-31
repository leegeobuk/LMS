package woowa.lms.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.repository.item.BookRepository;
import woowa.lms.back.service.item.BookService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest extends Account {

    static final String TITLE = "Hamlet";
    static final String AUTHOR = "Shakespeare";
    static final Book BOOK = Book.of(TITLE, AUTHOR, 5);

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    void save() {
        //given


        //when
        bookService.save(BOOK);

        //then
        verify(bookRepository).save(any(Book.class));
    }

    @Test
    void edit() {
        //given


        //when
//        itemService.edit();
// TODO: 2020-03-04 Test it when implemented
        //then

    }

    @Test
    void find() {
        //given
        when(bookRepository.findById(BOOK.getId())).thenReturn(BOOK);

        //when
        Item item = bookService.find(BOOK.getId());

        //then
        verify(bookRepository).findById(BOOK.getId());

        assertEquals(BOOK, item, "Wrong item returned from find");
    }

    @Test
    void findAll() {
        //given
        when(bookRepository.findAll()).thenReturn(List.of(BOOK));

        //when
        List<Book> items = bookService.findAll();

        //then
        verify(bookRepository).findAll();

        assertEquals(List.of(BOOK), items, "Wrong items returned from findAll");
    }
}