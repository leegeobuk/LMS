package woowa.lms.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.domain.rental.Rental;
import woowa.lms.back.repository.RentalRepository;
import woowa.lms.back.repository.account.AccountRepository;
import woowa.lms.back.repository.item.ItemRepository;
import woowa.lms.back.service.RentalService;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class RentalServiceTest {

    @Mock
    Account account;
    @Mock
    Item item;
    @Mock
    Rental rental;

    @Mock
    AccountRepository accountRepository;

    @Mock
    ItemRepository itemRepository;

    @Mock
    RentalRepository rentalRepository;

    @InjectMocks
    RentalService rentalService;

    @Test
    void lendBooks() {
        //given
        when(account.getId()).thenReturn("lee");
        when(item.getId()).thenReturn(1L);
        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        when(itemRepository.findById(item.getId())).thenReturn(Optional.of(item));

        //when
        rentalService.lendBooks(account.getId(), List.of(item.getId()));

        //then
        verify(accountRepository).findById(anyString());
        verify(itemRepository).findById(1L);
    }

    @Test
    void returnBooks() {
        //given
        when(account.getId()).thenReturn("lee");
        when(item.getId()).thenReturn(1L);
        when(rentalRepository.findByAccount(account.getId())).thenReturn(rental);

        //when
        rentalService.returnBooks(account.getId(), item.getId());

        //then
        verify(rentalRepository).findByAccount(account.getId());
        verify(rental).endRental(item.getId());
    }
}