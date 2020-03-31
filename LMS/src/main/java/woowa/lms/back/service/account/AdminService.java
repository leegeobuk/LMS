package woowa.lms.back.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.repository.account.AccountRepository;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminService implements AccountService<Admin>, Signable<Admin> {

    private final AccountRepository<Admin> accountRepository;

    @Transactional
    @Override
    public String signUp(Admin admin) throws IllegalStateException {
        validateDuplicate(admin);
        accountRepository.save(admin);
        return admin.getId();
    }

    private void validateDuplicate(Admin admin) throws IllegalStateException {
        Account found = accountRepository.findById(admin.getId());
        if (found != null) {
            throw new IllegalStateException("Id already exists!");
        }
    }

    @Override
    public Admin signIn(Admin admin) throws IllegalStateException {
        validateSignIn(admin);
        return admin;
    }

    private void validateSignIn(Admin admin) throws IllegalStateException {
        Account found = accountRepository.findById(admin.getId());
        if (found == null) {
            throw new IllegalStateException("Id doesn't exist!");
        }
        else if (!found.getPw().equals(admin.getPw())) {
            throw new IllegalStateException("Incorrect password!");
        }
    }

    @Transactional
    @Override
    public void edit(String id, String name, String contact) {
        Account account = accountRepository.findById(id);
        account.setName(name);
        account.setContact(contact);
    }

    @Override
    public Admin find(String id) {
        return (Admin) accountRepository.findById(id);
    }

    @Override
    public List<Admin> findAll() {
        return accountRepository.findAll()
            .stream().map(Admin.class::cast).collect(toUnmodifiableList());
    }
}
