package woowa.lms.service;

import woowa.lms.domain.account.Account;
import woowa.lms.repository.AccountRepository;

import java.util.List;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String singUp(Account account) {
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

    public Account find(String id) {
        return accountRepository.findById(id);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public void edit(String id, String name, String contact) {
        Account account = accountRepository.findById(id);
        account.setName(name);
        account.setContact(contact);
    }
}
