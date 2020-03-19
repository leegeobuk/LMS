package woowa.lms.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.repository.AccountRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public String signUp(Account account) {
        validateDuplicate(account);
        accountRepository.save(account);
        return account.getId();
    }

    private void validateDuplicate(Account account) {
        Account found = accountRepository.findById(account.getId());
        if (found != null) {
            throw new IllegalStateException("Id already exists!");
        }
    }

    @Transactional
    public void edit(String id, String name, String contact) {
        Account account = accountRepository.findById(id);
        account.setName(name);
        account.setContact(contact);
    }

    public Account find(String id) {
        return accountRepository.findById(id);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
