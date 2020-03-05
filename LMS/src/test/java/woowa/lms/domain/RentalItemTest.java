package woowa.lms.domain;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import woowa.lms.domain.account.Account;
import woowa.lms.domain.item.Book;
import woowa.lms.domain.item.Item;
import woowa.lms.domain.rental.RentalItem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class RentalItemTest extends Account {

    @Test
    void create() {
        //given
        Item item = mock(Item.class);
        doNothing().when(item).removeItem();

        //when
        RentalItem.create(item);

        //then
        verify(item).removeItem();
    }

    @Test
    void returnRentalItem() {
        //given
        RentalItem rentalItem = RentalItem.create(Book.of("S", "H", 1));
        int stock = rentalItem.getItem().getStock();

        //when
        rentalItem.returnRentalItem();

        //then
        assertEquals(++stock, rentalItem.getItem().getStock(),
            "Wrong stock returned from returnRenalItem");
    }
}