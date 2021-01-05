package woowa.lms.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.repository.item.ItemRepository;
import woowa.lms.back.service.item.BookService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ItemServiceTest {

    static final String TITLE = "Hamlet";
    static final String AUTHOR = "Shakespeare";
    static final Book BOOK = Book.of(TITLE, AUTHOR, 5);

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    BookService bookService;

    @Test
    void save() {
        //given


        //when
        bookService.save(BOOK);

        //then
        verify(itemRepository).save(any(Book.class));
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
        when(itemRepository.findBookById(BOOK.getId())).thenReturn(Optional.of(BOOK));

        //when
        Optional<Book> item = bookService.find(BOOK.getId());

        //then
        verify(itemRepository).findBookById(BOOK.getId());

        assertEquals(Optional.of(BOOK), item, "Wrong item returned from find");
    }

    @Test
    void findAll() {
        //given
        when(itemRepository.findAll()).thenReturn(List.of(BOOK));

        //when
        List<Book> items = bookService.findAll();

        //then
        verify(itemRepository).findAll();

        assertEquals(List.of(BOOK), items, "Wrong items returned from findAll");
    }
}