package woowa.lms.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import woowa.lms.domain.account.Account;
import woowa.lms.domain.account.Owner;
import woowa.lms.domain.item.Book;
import woowa.lms.domain.item.Item;
import woowa.lms.domain.rental.Rental;
import woowa.lms.domain.rental.RentalStatus;
import woowa.lms.repository.AccountRepository;
import woowa.lms.repository.ItemRepository;
import woowa.lms.repository.RentalRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentalServiceTest extends Account {

    //    Account account = Owner.of("lee", "pw");
//    Item item = Book.of("Shakespeare", "Hamlet", 1);
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