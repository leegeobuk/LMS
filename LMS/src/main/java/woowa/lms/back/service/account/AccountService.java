package woowa.lms.back.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.AccountSearchCriteria;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.repository.account.AccountRepository;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public String signUpAccount(Account account) throws IllegalStateException {
        validateDuplicate(account);
        accountRepository.save(account);
        return account.getId();
    }

    private void validateDuplicate(Account account) throws IllegalStateException {
        Account found = accountRepository.findById(account.getId());
        if (found != null) {
            throw new IllegalStateException("Id already exists!");
        }
    }

    public Account signInAccount(Account account) throws IllegalStateException {
        validateSignIn(account);
        return account;
    }

    private void validateSignIn(Account account) throws IllegalStateException {
        Account found = accountRepository.findById(account.getId());
        if (found == null) {
            throw new IllegalStateException("Id doesn't exist!");
        }
        else if (!found.getPw().equals(account.getPw())) {
            throw new IllegalStateException("Incorrect password!");
        }
    }

    @Transactional
    public void editAccount(String id, String name, String contact) {
        Account account = accountRepository.findById(id);
        account.setName(name);
        account.setContact(contact);
    }

    @Transactional
    public void deleteAccount(String  accountId) {
        Account account = findAccount(accountId);
        accountRepository.delete(account);
    }

    public Account findAccount(String id) {
        return accountRepository.findById(id);
    }

    public List<Admin> findAdmins() {
        return accountRepository.findAdmins().
            stream().map(Admin.class::cast).collect(toUnmodifiableList());
    }

    public List<User> findUsers() {
        return accountRepository.findUsers().
            stream().map(User.class::cast).collect(toUnmodifiableList());
    }

    public List<Account> findAll(AccountSearchCriteria criteria) {
        return accountRepository.findAll(criteria);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
