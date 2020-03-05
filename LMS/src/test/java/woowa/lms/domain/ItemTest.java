package woowa.lms.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import woowa.lms.domain.account.Account;
import woowa.lms.domain.item.Item;
import woowa.lms.exception.OutOfStockException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ItemTest extends Account {

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