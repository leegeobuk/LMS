package woowa.lms.back.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.repository.account.AccountRepository;
import woowa.lms.back.search.AccountSearchCriteria;

import java.util.List;
import java.util.Optional;

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
        accountRepository.findById(account.getId())
            .ifPresent(a -> {
                    throw new IllegalStateException("Id already exists!");
            });
    }

    public Account signInAccount(Account account) throws IllegalStateException {
        validateSignIn(account);
        return account;
    }

    private void validateSignIn(Account account) throws IllegalStateException {
        Optional<Account> found = accountRepository.findById(account.getId());
        if (found.isEmpty()) {
            throw new IllegalStateException("Id doesn't exist!");
        }
        else if (!found.get().getPw().equals(account.getPw())) {
            throw new IllegalStateException("Incorrect password!");
        }
    }

    @Transactional
    public void editAccount(String id, String name, String contact) {
        accountRepository.findById(id)
            .ifPresent(account -> {
                account.setName(name);
                account.setContact(contact);
            });
    }

    @Transactional
    public void deleteAccount(String  accountId) {
        findAccount(accountId)
            .ifPresent(accountRepository::delete);
    }

    public Optional<Account> findAccount(String id) {
        return accountRepository.findById(id);
    }

    public List<Admin> findAdmins() {
        return accountRepository.findAdmins().stream()
            .map(Admin.class::cast).collect(toUnmodifiableList());
    }

    public List<User> findUsers() {
        return accountRepository.findUsers().stream()
            .map(User.class::cast).collect(toUnmodifiableList());
    }

    public List<Account> search(AccountSearchCriteria criteria) {
        return accountRepository.search(criteria);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
