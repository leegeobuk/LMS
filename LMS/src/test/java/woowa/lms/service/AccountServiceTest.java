package woowa.lms.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Owner;
import woowa.lms.back.repository.AccountRepository;
import woowa.lms.back.service.AccountService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest extends Account {

    static final String ID = "leegeobuk";
    static final String PW = "password";
    static final Owner OWNER = Owner.of(ID, PW);

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountService accountService;

    @Test
    void singUp() {
        //given
        when(accountRepository.findById(anyString())).thenReturn(null);

        //when
        String ownerId = accountService.signUp(OWNER);

        //then
        verify(accountRepository).save(any(Account.class));
        
        assertEquals(ID, ownerId, "Wrong account_id returned from signUp");
    }

    @Test
    void testValidateDuplicateException() {
        //given
        when(accountRepository.findById(anyString())).thenReturn(OWNER);

        //when
        assertThrows(IllegalStateException.class, () -> accountService.signUp(OWNER),
            "Exception not thrown when signUp duplicated");

        //then
        verify(accountRepository).findById(anyString());
        verify(accountRepository, never()).save(any(Account.class));
    }

    @Test
    void edit() {
        //given
        Owner ownerMock = mock(Owner.class);
        when(accountRepository.findById(anyString())).thenReturn(ownerMock);

        //when
        accountService.edit(ID, "lego", "01011112222");

        //then
        verify(accountRepository).findById(anyString());
        verify(ownerMock).setName(anyString());
        verify(ownerMock).setContact(anyString());
    }

    @Test
    void find() {
        //given
        when(accountRepository.findById(anyString())).thenReturn(OWNER);

        //when
        Account account = accountService.find(ID);

        //then
        verify(accountRepository).findById(anyString());

        assertEquals(OWNER, account, "Wrong account returned from find");
    }

    @Test
    void findAll() {
        //given
        when(accountRepository.findAll()).thenReturn(List.of(OWNER));

        //when
        List<Account> accounts = accountService.findAll();

        //then
        verify(accountRepository).findAll();

        assertEquals(List.of(OWNER), accounts, "Wrong List returned from findAll");
    }
}