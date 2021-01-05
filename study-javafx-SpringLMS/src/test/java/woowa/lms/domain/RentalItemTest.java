package woowa.lms.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.domain.rental.RentalItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class RentalItemTest {

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