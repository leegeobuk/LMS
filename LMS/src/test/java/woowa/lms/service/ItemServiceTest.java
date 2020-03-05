package woowa.lms.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import woowa.lms.domain.account.Account;
import woowa.lms.domain.item.Book;
import woowa.lms.domain.item.Item;
import woowa.lms.repository.ItemRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest extends Account {

    static final String TITLE = "Hamlet";
    static final String AUTHOR = "Shakespeare";
    static final Item BOOK = Book.of(TITLE, AUTHOR, 5);

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemService itemService;

    @Test
    void save() {
        //given


        //when
        itemService.save(BOOK);

        //then
        verify(itemRepository).save(any(Item.class));
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
        when(itemRepository.findById(BOOK.getId())).thenReturn(BOOK);

        //when
        Item item = itemService.find(BOOK.getId());

        //then
        verify(itemRepository).findById(BOOK.getId());

        assertEquals(BOOK, item, "Wrong item returned from find");
    }

    @Test
    void findAll() {
        //given
        when(itemRepository.findAll()).thenReturn(List.of(BOOK));

        //when
        List<Item> items = itemService.findAll();

        //then
        verify(itemRepository).findAll();

        assertEquals(List.of(BOOK), items, "Wrong items returned from findAll");
    }
}