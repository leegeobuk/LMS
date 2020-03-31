package woowa.lms.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.domain.account.Owner;
import woowa.lms.back.repository.account.AdminRepository;
import woowa.lms.back.service.account.AdminService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest extends Account {

    static final String ID = "leegeobuk";
    static final String PW = "password";
    static final Admin ADMIN = Admin.of(ID, PW);

    @Mock
    AdminRepository adminRepository;

    @InjectMocks
    AdminService adminService;

    @Test
    void singUp() {
        //given
        when(adminRepository.findById(anyString())).thenReturn(null);

        //when
        String ownerId = adminService.signUp(ADMIN);

        //then
        verify(adminRepository).save(any(Admin.class));
        
        assertEquals(ID, ownerId, "Wrong account_id returned from signUp");
    }

    @Test
    void testValidateDuplicateException() {
        //given
        when(adminRepository.findById(anyString())).thenReturn(ADMIN);

        //when
        assertThrows(IllegalStateException.class, () -> adminService.signUp(ADMIN),
            "Exception not thrown when signUp duplicated");

        //then
        verify(adminRepository).findById(anyString());
        verify(adminRepository, never()).save(any(Admin.class));
    }

    @Test
    void edit() {
        //given
        Owner ownerMock = mock(Owner.class);
        when(adminRepository.findById(anyString())).thenReturn(ownerMock);

        //when
        adminService.edit(ID, "lego", "01011112222");

        //then
        verify(adminRepository).findById(anyString());
        verify(ownerMock).setName(anyString());
        verify(ownerMock).setContact(anyString());
    }

    @Test
    void find() {
        //given
        when(adminRepository.findById(anyString())).thenReturn(ADMIN);

        //when
        Account account = adminService.find(ID);

        //then
        verify(adminRepository).findById(anyString());

        assertEquals(ADMIN, account, "Wrong account returned from find");
    }

    @Test
    void findAll() {
        //given
        when(adminRepository.findAll()).thenReturn(List.of(ADMIN));

        //when
        List<Admin> accounts = adminService.findAll();

        //then
        verify(adminRepository).findAll();

        assertEquals(List.of(ADMIN), accounts, "Wrong List returned from findAll");
    }
}