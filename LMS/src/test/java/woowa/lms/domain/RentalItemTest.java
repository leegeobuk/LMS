package woowa.lms.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.domain.rental.RentalItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RentalItemTest extends Account {

    @Mock
    Item item;

    @Mock
    RentalItem rentalItem;

    @Test
    void create() {
        //given


        //when
        RentalItem.create(item);

        //then
        verify(item).removeItem();
    }

    @Test
    void returnRentalItem() {
        //given
//        RentalItem rentalItem = RentalItem.create(Book.of("S", "H", 1));
        RentalItem rentalItem = RentalItem.create(item);
        when(item.getStock()).thenReturn(0, 1);

        //when
        int stock = rentalItem.getItem().getStock();
        rentalItem.returnRentalItem();

        //then
        verify(item).addItem();

        assertEquals(++stock, rentalItem.getItem().getStock(),
            "Wrong stock returned from returnRenalItem");
    }
}