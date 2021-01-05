package woowa.lms.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.exception.OutOfStockException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ItemTest {

    @Mock
    Item item;

    @Test
    void removeItem() {
        //given
        doThrow(OutOfStockException.class).when(item).removeItem();

        //when
        assertThrows(OutOfStockException.class, item::removeItem,
            "Exception not thrown when stock is 0");

        //then
        verify(item).removeItem();
    }
}