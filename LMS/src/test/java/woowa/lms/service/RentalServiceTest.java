package woowa.lms.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.domain.rental.Rental;
import woowa.lms.back.repository.RentalRepository;
import woowa.lms.back.repository.account.AccountRepository;
import woowa.lms.back.repository.item.ItemRepository;
import woowa.lms.back.service.RentalService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentalServiceTest extends Account {

    @Mock
    Account account;
    @Mock
    Item item;
    @Mock
    Rental rental;

    @Mock
    AccountRepository accountRepository;

    @Mock
    ItemRepository<Book> itemRepository;

    @Mock
    RentalRepository rentalRepository;

    @InjectMocks
    RentalService rentalService;

    @Test
    void lendBooks() {
        //given
        when(account.getId()).thenReturn("lee");
        when(item.getId()).thenReturn(1L);
        when(accountRepository.findById(account.getId())).thenReturn(account);
        when(itemRepository.findById(item.getId())).thenReturn(item);

        //when
        rentalService.lendBooks(account.getId(), item.getId());

        //then
        verify(accountRepository).findById(anyString());
        verify(itemRepository).findById(1L);
    }

    @Test
    void returnBooks() {
        //given
        when(rental.getId()).thenReturn(1L);
        when(rentalRepository.findById(rental.getId())).thenReturn(rental);

        //when
        rentalService.returnBooks(rental.getId());

        //then
        verify(rentalRepository).findById(rental.getId());
        verify(rental).endRental();
    }
}